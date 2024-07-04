select * from world.city;

CREATE TABLE employee.department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE employee.address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    zipcode VARCHAR(20) NOT NULL
);

CREATE TABLE employee.employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    department_id BIGINT,
    address_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES department(id),
    FOREIGN KEY (address_id) REFERENCES address(id)
);


INSERT INTO employee.department (name) VALUES ('HR'), ('Finance'), ('IT');

INSERT INTO employee.address (street, city, state, zipcode) VALUES 
('123 Main St', 'Springfield', 'IL', '62701'),
('456 Elm St', 'Springfield', 'IL', '62702'),
('789 Oak St', 'Springfield', 'IL', '62703');


INSERT INTO employee.employee (name, email, department_id, address_id) VALUES 
('John Doe', 'john.doe@example.com', 1, 1),
('Jane Smith', 'jane.smith@example.com', 2, 2),
('Robert Brown', 'robert.brown@example.com', 3, 3);