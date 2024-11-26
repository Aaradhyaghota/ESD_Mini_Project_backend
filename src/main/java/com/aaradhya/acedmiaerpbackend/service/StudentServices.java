package com.aaradhya.acedmiaerpbackend.service;

import com.aaradhya.acedmiaerpbackend.entity.Domain;
import com.aaradhya.acedmiaerpbackend.entity.Placement;
import com.aaradhya.acedmiaerpbackend.entity.Specialization;
import com.aaradhya.acedmiaerpbackend.entity.Students;
import com.aaradhya.acedmiaerpbackend.helper.EncryptionService;
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
    private final EncryptionService encryptionService;

    @Value("${photograph.upload-dir}") // Directory path from application.properties
    private String uploadDir;

    public String registerStudent(Students student, MultipartFile photograph) {
        try {
            String rollNumber = generateNextSequentialNumber(student.getDomain());
            if (studentRepo.existsByRollNumber(rollNumber)) {
                throw new RuntimeException("Roll number " + rollNumber + " already exists.");
            }

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

    private String generateNextSequentialNumber(Domain domain) {
        String program = domain.getProgram();
        int batchYear = domain.getBatch();

        // Query the database for the last generated roll number in the given domain and batch
        String lastRollNumber = studentRepo.findLastRollNumberByDomainAndBatch(domain.getDomainId(), domain.getBatch());
        int domainID = domain.getDomainId();
        // If there is no previous roll number, start from 00001
        // If no roll number exists, start with the first one
        if (lastRollNumber == null) {
            if (program.startsWith("MTech")) {
                return "MT" + batchYear + domainID + "00001";
            } else if (program.startsWith("BTech")) {
                return "BT" + batchYear + domainID + "00001";
            } else if (program.startsWith("Ph.D.")) {
                return "PHD" + batchYear + domainID + "00001";
            }
        }

        // Extract the numeric part of the roll number
        String rollNumberPart = lastRollNumber.substring(lastRollNumber.length() - 5);
        int nextRollNumber = Integer.parseInt(rollNumberPart) + 1;

        if (program.startsWith("MTech")) {
            return "MT" + batchYear + domainID + String.format("%05d", nextRollNumber);
        } else if (program.startsWith("BTech")) {
            return "BT" + batchYear + domainID + String.format("%05d", nextRollNumber);
        } else if (program.startsWith("Ph.D.")) {
            return "PHD" + batchYear + domainID + String.format("%05d", nextRollNumber);
        }

        return null;
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

    public Domain getDomains(int id) throws RuntimeException {
        return domainRepo.findById(id).orElseThrow( ()-> new RuntimeException("Domain not found"));
    }

    public Specialization getSpez(int id) throws RuntimeException {
        return specializationRepo.findById(id).orElseThrow( ()-> new RuntimeException("Specialization not found"));
    }

    public Placement getPlacement(int id) throws RuntimeException {
        return placementRepo.findById(id).orElseThrow( ()-> new RuntimeException("Placement not found"));
    }


}
