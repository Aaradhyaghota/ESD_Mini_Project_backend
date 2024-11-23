# use Acedmia_ERP;
#
# -- Foreign key constraints for Students table
# ALTER TABLE students
#     ADD CONSTRAINT domain_fk
#         FOREIGN KEY (domain_fk)
#             REFERENCES domains(domain_id);
#
# ALTER TABLE students
#     ADD CONSTRAINT specialization_fk
#         FOREIGN KEY (specialization_fk)
#             REFERENCES specialization(specialization_id);
#
# ALTER TABLE students
#     ADD CONSTRAINT placement_fk
#         FOREIGN KEY (placement_fk)
#             REFERENCES placement(id);
#
# -- Foreign key for Placement table
# ALTER TABLE placement
#     ADD CONSTRAINT organization_fk
#         FOREIGN KEY (organization_fk)
#             REFERENCES organizations(id);
#
# -- Additional constraints for Students table
# ALTER TABLE students
#     ADD CONSTRAINT chk_email_format CHECK (email LIKE '%@%.%');
#
#
#
# ALTER TABLE students
#     ADD CONSTRAINT chk_cgpa_range CHECK (cgpa >= 0 AND cgpa <= 10);
