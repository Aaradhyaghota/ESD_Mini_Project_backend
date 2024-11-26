#  -- Insert records for BTech programs
#  INSERT INTO domains (program, batch, capacity, qualification)
#  VALUES
#      ('BTech (Computer Science)', '2024', 50, '12th Pass with Science Stream'),
#      ('BTech (Electronics and Communication)', '2024', 50, '12th Pass with Science Stream');
#
#  -- Insert records for MTech programs
#  INSERT INTO domains (program, batch, capacity, qualification)
#  VALUES
#      ('MTech (Computer Science and Engineering)', '2024', 50, 'BTech in Computer Science or related field'),
#      ('MTech (Electronics and Communication Engineering)', '2024', 50, 'BTech in Electronics and Communication or related field');
#
#  -- Insert records for MTech specializations
#  INSERT INTO domains (program, batch, capacity, qualification)
#  VALUES
#      ('MTech (Artificial Intelligence)', '2024', 50, 'BTech in Computer Science or related field'),
#      ('MTech (Machine Learning)', '2024', 50, 'BTech in Computer Science or related field'),
#      ('MTech (Data Science)', '2024', 50, 'BTech in Computer Science or related field'),
#      ('MTech (VLSI Design)', '2024', 50, 'BTech in Electronics and Communication or related field'),
#      ('MTech (Embedded Systems)', '2024', 50, 'BTech in Electronics and Communication or related field');
#
#  -- Insert records for Ph.D. programs
#  INSERT INTO domains (program, batch, capacity, qualification)
#  VALUES
#      ('Ph.D. (Computer Science)', '2024', 50, 'MTech in Computer Science or related field'),
#      ('Ph.D. (Electronics and Communication)', '2024', 50, 'MTech in Electronics and Communication or related field');
#
#
#  -- Insert records for Specializations
#  INSERT INTO specialization (code, name, description, year, credits_required)
#  VALUES
#      ('CSAI', 'Artificial Intelligence', 'Focuses on creating intelligent systems capable of learning and adapting.', 2, 30),
#      ('CSML', 'Machine Learning', 'Specialization in algorithms and models that allow machines to learn from data.', 2, 30),
#      ('CSDT', 'Data Science', 'A blend of statistical methods, data analysis, and machine learning techniques to handle large datasets.', 2, 30),
#      ('CSDS', 'Data Science', 'A focus on data modeling and analysis techniques used to extract meaningful insights.', 2, 30),
#      ('ECEVLSI', 'VLSI Design', 'Specialization in the design of integrated circuits and electronic systems at the micro-level.', 2, 30),
#      ('ECEES', 'Embedded Systems', 'Focuses on designing specialized computing systems for specific applications.', 2, 30),
#      ('PhD-CSAI', 'Ph.D. in Artificial Intelligence', 'Advanced research in the field of AI, including machine learning and neural networks.', 5, 90),
#      ('PhD-CSML', 'Ph.D. in Machine Learning', 'In-depth research on algorithms, statistical models, and deep learning techniques.', 5, 90),
#      ('PhD-CSDT', 'Ph.D. in Data Science', 'Research in the application of data science techniques to real-world problems.', 5, 90),
#      ('PhD-ECEVLSI', 'Ph.D. in VLSI Design', 'Advanced study and research in VLSI design, fabrication, and related technologies.', 5, 90),
#      ('PhD-ECEES', 'Ph.D. in Embedded Systems', 'Research focusing on embedded system design, IoT, and hardware integration.', 5, 90);
#
#
#  -- Inserting records for IT Companies
#  INSERT INTO organizations (id, name ,address)
#  VALUES
#      (1,'NA','NA'),
#      (2, 'Tata Consultancy Services',   'Mumbai, India'),
#      (3, 'Infosys',   'Bengaluru, India'),
#      (4, 'Wipro',  'Bengaluru, India'),
#      (5, 'Accenture', 'Dublin, Ireland'),
#      (6, 'Cognizant',  'Teaneck, New Jersey, USA'),
#      (7, 'HCL Technologies', 'Noida, India'),
#      (8, 'Tech Mahindra', 'Pune, India'),
#      (9, 'Capgemini',  'Paris, France');
#
#
#  -- Inserting records for Electronics Companies
#  INSERT INTO organizations (id, name, address)
#  VALUES
#      (10, 'Samsung Electronics', 'Seoul, South Korea'),
#      (11, 'Sony Corporation',  'Tokyo, Japan'),
#      (12, 'Intel Corporation', 'Santa Clara, California, USA');
#
#  -- Inserting Placement records for IT Companies
#  INSERT INTO placement (id, organization_fk, profile, intake, minimum_grade, description)
#  VALUES
#      (1, 1, 'NA', 0, 0,'NA'),
#      (2, 2, 'SDE', 10, 3.50, 'Tata Consultancy Services offers internships and full-time placements for B.Tech students in various engineering disciplines.'),
#      (3, 3, 'SDE', 8, 3.80, 'Infosys provides M.Tech placements in software development and IT consulting roles, with a focus on technology innovation.'),
#      (4, 4, 'SDE', 7, 3.70, 'Wipro hires B.Tech graduates for software engineering and consulting roles, focusing on digital transformation and tech development.'),
#      (5, 5, 'SDE', 6, 3.90, 'Accenture recruits M.Tech students for high-level consulting, technology innovation, and IT infrastructure roles.'),
#      (6, 6, 'SDE', 9, 3.60, 'Cognizant offers B.Tech placements in software development, IT solutions, and consulting services, with opportunities for international exposure.'),
#      (7, 7, 'SDE', 10, 3.85, 'HCL Technologies hires M.Tech graduates for advanced technology and R&D positions, including roles in cloud computing and AI.'),
#      (8, 8, 'SDE', 6, 3.55, 'Tech Mahindra offers B.Tech placements in IT, consulting, and engineering domains, with a strong focus on digital technologies.'),
#      (9, 9, 'SDE', 5, 3.95, 'Capgemini provides M.Tech students with opportunities in technology consulting, software engineering, and AI research.'),
#
#  -- Inserting Placement records for Electronics Companies
#      (10, 10, 'Engineer', 8, 3.60, 'Samsung Electronics hires B.Tech students for hardware design, semiconductor engineering, and consumer electronics projects.'),
#      (11, 11, 'Engineer', 7, 3.80, 'Sony Corporation offers M.Tech placements in electronics engineering, robotics, and AI for consumer electronics.'),
#      (12, 12, 'Engineer', 6, 3.70, 'Intel recruits B.Tech graduates for hardware development, VLSI design, and semiconductor research and development roles.');
