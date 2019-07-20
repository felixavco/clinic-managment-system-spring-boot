CREATE DATABASE clinic_management_system; 

USE clinic_management_system; 

-- Relation with users: ONE TO MANY 
-- Relation with patients: ONE TO MANY 
CREATE TABLE clinics (
    id bigint NOT NULL AUTO_INCREMENT,
    clinic_name varchar(255) UNIQUE, 
    domain varchar(100) UNIQUE,
    clinic_url varchar(50) UNIQUE,
    speciality varchar(255), 
    logo varchar(255),

    -- Address
    address_line varchar(255),
    address_line2 varchar(255),
    state varchar(100),
    city varchar(100),

    -- Contact Information
    primary_phone varchar(50), 
    secondary_phone varchar(50),
    whatsapp varchar(50), 
    email varchar(255),

    -- Social Media
    facebook varchar(255), 
    instagram varchar(255), 
    twitter varchar(255), 
    youtube varchar(255), 
    linkedin varchar(255),
    
    is_verified boolean default false,
    is_active boolean default true,
    is_trial boolean default true,
    verification_token varchar(255) not null,
    verification_token_exp timestamp not null,
    
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id)
);

-- Relation with roles: ONE TO ONE 
-- Relation with permissions: ONE TO ONE 
-- Relation with clinics: ONE TO ONE 
CREATE TABLE users (
    id bigint NOT NULL AUTO_INCREMENT,
    first_name varchar(50) NOT NULL, 
    middle_name varchar(50),
    last_name varchar(50) NOT NULL, 
    last_name2 varchar(50),
    speciality varchar(255), 
    profile_picture varchar(255),

    user_name varchar(50),
    email varchar(255) NOT NULL,
    pwd varchar(255) NOT NULL, 
    
    is_active boolean default true, 
    pwd_recovery_token varchar(255),
    pwd_recovery_exp timestamp,
    
    clinic bigint NOT NULL,
 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    PRIMARY KEY (id),
    FOREIGN KEY (clinic) REFERENCES clinics(id) ON DELETE CASCADE,
);

CREATE TABLE roles (
	-- Roles: Doctor, Enfermera, Administrador, Licenciado 
	id bigint not null auto_increment, 
    rol varchar(10),
    _user bigint not null,
    
	PRIMARY KEY (id),
    FOREIGN KEY (_user) REFERENCES users(id) ON DELETE CASCADE,
);

-- Relation with clinics: ONE TO ONE 
CREATE TABLE patients (
    id bigint NOT NULL AUTO_INCREMENT,
    first_name varchar(50) NOT NULL, 
    middle_name varchar(50),
    last_name varchar(50) NOT NULL, 
    last_name2 varchar(50),
    email varchar(255),
    primary_phone varchar(20),
    secondary_phone varchar(20),

    --Clinic Information
    dob date NOT NULL,
    blood_type varchar(10), 
    alergies text,
    notes text,

    -- Insurance information
    insurance_number varchar(255),
    insurance_provider varchar(255), 

    -- Address
    address_line varchar(255),
    address_line2 varchar(255),
    _state varchar(100),
    city varchar(100),

    clinic bigint NOT NULL,
    
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    PRIMARY KEY (id),
    FOREIGN KEY (clinic) REFERENCES clinics(id) ON DELETE CASCADE
);


-- Relation with medical_records: MANY TO ONE 
-- Relation with users: ONE TO ONE 
CREATE TABLE medical_visits (
	id bigint not null auto_increment, 

    temperature float, 
    blood_presure varchar(10),
    height float, 
    weight float,

    diagnose varchar(255),
    notes text,
    
	patient_record bigint not null, 
    patient bigint not null,
    
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    PRIMARY KEY (id),
	FOREIGN KEY (patient) REFERENCES patients(id) ON DELETE CASCADE
);

-- Relation with medical_visits: ONE TO ONE 
CREATE TABLE prescriptions (
	prescription_id bigint not null auto_increment,
    medical_visit bigint not null,
    product varchar(255), 
    quantity float, 
    unit varchar(10),

    
    PRIMARY KEY (prescription_id),
    FOREIGN KEY (medical_visit) REFERENCES medical_visits(id) ON DELETE CASCADE
);


-- Relation with users: MANY TO ONE
-- Relation with patient: MANY TO ONE
CREATE TABLE calendar_events (
	id bigint not null auto_increment,
    event_owner bigint not null, 
    patient bigint,
    
    start_time timestamp not null,
    end_time timestamp,
    title varchar(255),
    description text,
    
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    PRIMARY KEY (id),
    FOREIGN KEY (patient) REFERENCES patients(id) ON DELETE CASCADE,
	FOREIGN KEY (event_owner) REFERENCES users(id) ON DELETE CASCADE
);







