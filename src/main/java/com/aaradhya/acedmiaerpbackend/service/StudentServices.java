package com.aaradhya.acedmiaerpbackend.service;

import com.aaradhya.acedmiaerpbackend.entity.Domain;
import com.aaradhya.acedmiaerpbackend.entity.Placement;
import com.aaradhya.acedmiaerpbackend.entity.Specialization;
import com.aaradhya.acedmiaerpbackend.entity.Students;
import com.aaradhya.acedmiaerpbackend.repo.DomainRepo;
import com.aaradhya.acedmiaerpbackend.repo.PlacementRepo;
import com.aaradhya.acedmiaerpbackend.repo.SpecializationRepo;
import com.aaradhya.acedmiaerpbackend.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServices {
    private final StudentRepo studentRepo;
    private final DomainRepo domainRepo;
    private final SpecializationRepo specializationRepo;
    private final PlacementRepo placementRepo;

    @Value("${photograph.upload-dir}") // Directory path from application.properties
    private String uploadDir;

    public String registerStudent(Students student, MultipartFile photograph) {
        try {
            String rollNumber = generateRollNumber(student.getDomain());

            student.setRollNumber(rollNumber);

            String photographPath = savePhotograph(photograph);
            student.setPhotographPath(photographPath);

            studentRepo.save(student);
            return "Student registered successfully : " + rollNumber;
        } catch (Exception e) {
            throw new RuntimeException("Error registering student: " + e.getMessage());
        }
    }

    private String savePhotograph(MultipartFile photograph) throws IOException {
        if (photograph.isEmpty()) {
            throw new IOException("Photograph is empty");
        }

        String originalFileName = photograph.getOriginalFilename();
        // Extract the file extension (if available)
        String fileExtension = "";
        assert originalFileName != null;
        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex > 0) {
            fileExtension = originalFileName.substring(dotIndex);
        }

        // Generate a new file name with the current timestamp
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = originalFileName.replace(fileExtension, "") + "_" + timeStamp + fileExtension;

        // Define the path to save the file
        Path filePath = Paths.get(uploadDir + File.separator + fileName);

        // Save the file to the specified directory
        Files.copy(photograph.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Return the file path as a string
        return filePath.toString();
    }


    //roll no.
    private String generateRollNumber(Domain domain) {
        // Extract the full batch year (e.g., 2024)
        String batchYear = String.valueOf(domain.getBatch());

        // Determine the program prefix
        String programPrefix = getProgramPrefix(domain.getProgram());

        // Generate the next sequential roll number (fetch from DB)
        String sequentialNumber = generateNextSequentialNumber(domain);

        // Combine program prefix, batch year, and sequential number to form the roll number
        return programPrefix + batchYear + sequentialNumber;
    }

    private String generateNextSequentialNumber(Domain domain) {
        // Fetch the last roll number generated for this domain and batch from the database
        String lastRollNumber = studentRepo.findLastRollNumberByDomainAndBatch(domain.getDomainId(), domain.getBatch());

        // If no roll number exists yet, start with '00001'
        if (lastRollNumber == null) {
            return "00001";
        }

        // Extract the numeric part of the last roll number
        String lastSequentialPart = lastRollNumber.substring(lastRollNumber.length() - 5);

        // Increment the numeric part by 1
        int nextSequentialNumber = Integer.parseInt(lastSequentialPart) + 1;

        // Format it back to a 5-digit string
        return String.format("%05d", nextSequentialNumber);
    }

    private static String getProgramPrefix(String programName) {
        if (programName.contains("BTech")) {
            return "BT";
        } else if (programName.contains("MTech")) {
            return "MT";
        } else if (programName.contains("Ph.D.")) {
            return "PHD";
        } else {
            return "OT"; // Default to "OT" (Other) if program is not recognized
        }
    }

    public List<Domain> getAllDomains() {
        return domainRepo.findAll();
    }

    public List<Specialization> getAllSpecializations() {
        return specializationRepo.findAll();
    }

    public List<Placement> getAllPlacement() {
        return placementRepo.findAll();
    }

    public Domain getDomain(int id) throws RuntimeException {
        return domainRepo.findById(id).orElseThrow( ()-> new RuntimeException("Domain not found"));
    }

    public Specialization getSpez(int id) throws RuntimeException {
        return specializationRepo.findById(id).orElseThrow( ()-> new RuntimeException("Specialization not found"));
    }

    public Placement getPlacement(int id) throws RuntimeException {
        return placementRepo.findById(id).orElseThrow( ()-> new RuntimeException("Placement not found"));
    }
}
