CREATE DATABASE IF NOT EXISTS Acedmia_ERP;

USE Acedmia_ERP;


-- Domains table creation
CREATE TABLE IF NOT EXISTS domains (
    domain_id INT PRIMARY KEY AUTO_INCREMENT,
    program VARCHAR(100),
    batch INT,
    capacity INT,
    qualification VARCHAR(255)
    );

-- Specialization table creation
CREATE TABLE IF NOT EXISTS specialization (
    specialization_id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100),
    description TEXT,
    year INT,
    credits_required INT
    );

-- Organization table creation
CREATE TABLE IF NOT EXISTS organizations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    address VARCHAR(500)
    );

-- Placement table creation
CREATE TABLE IF NOT EXISTS placement (
    id INT PRIMARY KEY AUTO_INCREMENT,
    organization_fk INT,
    profile VARCHAR(100),
    description TEXT,
    intake INT,
    minimum_grade DECIMAL(3, 2)
    );

-- Students table creation
CREATE TABLE IF NOT EXISTS students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    roll_number VARCHAR(20) UNIQUE NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(255) UNIQUE NOT NULL,
    photograph_path VARCHAR(255),
    cgpa DECIMAL(3, 2),
    total_credits INT,
    graduation_year INT,
    domain_fk INT,
    specialization_fk INT,
    placement_fk INT
    );

CREATE TABLE IF NOT EXISTS admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
    );