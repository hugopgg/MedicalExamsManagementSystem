package com.inf5153;

import com.inf5153.patient.Patient;
import com.inf5153.patient.PatientManager;
import com.inf5153.prescription.Prescription;
import com.inf5153.prescription.PrescriptionManager;
import com.inf5153.service.Service;
import com.inf5153.service.ServiceManager;
import com.inf5153.service.ServiceType;

import com.inf5153.appointment.AppointmentManager;
import com.inf5153.appointment.AppointmentRequest;
import com.inf5153.doctor.Doctor;
import com.inf5153.doctor.DoctorManager;
import com.inf5153.exam.*;
import com.inf5153.exam.composite.CompositeExamType;
import com.inf5153.exam.elementary.ElementaryExamType;
import com.inf5153.healthcarecenter.HealthCareCenterManager;
import com.inf5153.labhub.LabHub;

public class App {
        public static void main(String[] args) {

                // GUI (real app)
                initData();
                Fx.launch(Fx.class, args);

                // uncomment for regular testing NO GUI
                // testHCC2();

        }

        // Hardcoding data
        private static void initData() {

                LabHub labHub = LabHub.getInstance();
                HealthCareCenterManager hcc = HealthCareCenterManager.getInstance(labHub);

                DoctorManager dm = DoctorManager.getInstance();
                ServiceManager sm = ServiceManager.getInstance();
                PatientManager pm = PatientManager.getInstance();

                Service service1 = sm.createService(ServiceType.CARDIO, "514-123-4567", "cardio@healthcare.com");
                Service service2 = sm.createService(ServiceType.GASTRO, "514-234-5678", "gastro@healthcare.com");
                Service service3 = sm.createService(ServiceType.NEPHRO, "514-345-6789", "nephro@healthcare.com");

                Doctor doctor1 = dm.createDoctor("1001", service1, "Dr. Jean Bon", "514-555-0101",
                                "jean.bon@healthcare.com");
                Doctor doctor2 = dm.createDoctor("1002", service1, "Dr. Marie Curie", "514-555-0102",
                                "marie.curie@healthcare.com");
                Doctor doctor3 = dm.createDoctor("1003", service1, "Dr. Albert Einstein", "514-555-0103",
                                "albert.einstein@healthcare.com");

                Doctor doctor4 = dm.createDoctor("2001", service2, "Dr. Greg House", "514-555-0201",
                                "greg.house@healthcare.com");
                Doctor doctor5 = dm.createDoctor("2002", service2, "Dr. Meredith Grey", "514-555-0202",
                                "meredith.grey@healthcare.com");
                Doctor doctor6 = dm.createDoctor("2003", service2, "Dr. Derek Shepherd", "514-555-0203",
                                "derek.shepherd@healthcare.com");

                Doctor doctor7 = dm.createDoctor("3001", service3, "Dr. Lisa Cuddy", "514-555-0301",
                                "lisa.cuddy@healthcare.com");
                Doctor doctor8 = dm.createDoctor("3002", service3, "Dr. John Watson", "514-555-0302",
                                "john.watson@healthcare.com");
                Doctor doctor9 = dm.createDoctor("3003", service3, "Dr. Gregory Pratt", "514-555-0303",
                                "gregory.pratt@healthcare.com");

                service1.addDoctor(doctor1);
                service1.addDoctor(doctor2);
                service1.addDoctor(doctor3);

                service2.addDoctor(doctor4);
                service2.addDoctor(doctor5);
                service2.addDoctor(doctor6);

                service3.addDoctor(doctor7);
                service3.addDoctor(doctor8);
                service3.addDoctor(doctor9);

                hcc.addService(service1);
                hcc.addService(service2);
                hcc.addService(service3);

                Patient patient1 = pm.createPatient("John Doe", "555-9876", "john.doe@example.com");
                Patient patient2 = pm.createPatient("Jane Doe", "555-9877", "jane.doe@example.com");
                Patient patient3 = pm.createPatient("Alice Smith", "555-9878", "alice.smith@example.com");
                Patient patient4 = pm.createPatient("Bob Brown", "555-9879", "bob.brown@example.com");
                Patient patient5 = pm.createPatient("Carol White", "555-9880", "carol.white@example.com");
                Patient patient6 = pm.createPatient("Dave Black", "555-9881", "dave.black@example.com");
                Patient patient7 = pm.createPatient("Eve Green", "555-9882", "eve.green@example.com");
                Patient patient8 = pm.createPatient("Frank Red", "555-9883", "frank.red@example.com");
                Patient patient9 = pm.createPatient("Grace Blue", "555-9884", "grace.blue@example.com");
                Patient patient10 = pm.createPatient("Hank Yellow", "555-9885", "hank.yellow@example.com");
                Patient patient11 = pm.createPatient("Ivy Purple", "555-9886", "ivy.purple@example.com");
                Patient patient12 = pm.createPatient("Jack Orange", "555-9887", "jack.orange@example.com");
                Patient patient13 = pm.createPatient("Kate Pink", "555-9888", "kate.pink@example.com");
                Patient patient14 = pm.createPatient("Leo Gray", "555-9889", "leo.gray@example.com");
                Patient patient15 = pm.createPatient("Mia Brown", "555-9890", "mia.brown@example.com");

                doctor1.addPatient(patient1);
                doctor1.addPatient(patient2);
                doctor1.addPatient(patient3);
                doctor1.addPatient(patient4);
                doctor1.addPatient(patient5);

                doctor2.addPatient(patient6);
                doctor2.addPatient(patient7);
                doctor2.addPatient(patient8);
                doctor2.addPatient(patient9);
                doctor2.addPatient(patient10);

                doctor3.addPatient(patient11);
                doctor3.addPatient(patient12);
                doctor3.addPatient(patient13);
                doctor3.addPatient(patient14);
                doctor3.addPatient(patient15);

                doctor4.addPatient(patient11);
                doctor4.addPatient(patient12);
                doctor4.addPatient(patient13);
                doctor4.addPatient(patient14);
                doctor4.addPatient(patient15);

                doctor5.addPatient(patient1);
                doctor5.addPatient(patient2);
                doctor5.addPatient(patient3);
                doctor5.addPatient(patient4);
                doctor5.addPatient(patient5);

                doctor6.addPatient(patient6);
                doctor6.addPatient(patient7);
                doctor6.addPatient(patient8);
                doctor6.addPatient(patient9);
                doctor6.addPatient(patient10);

                doctor7.addPatient(patient11);
                doctor7.addPatient(patient12);
                doctor7.addPatient(patient13);
                doctor7.addPatient(patient14);
                doctor7.addPatient(patient15);

                doctor8.addPatient(patient1);
                doctor8.addPatient(patient2);
                doctor8.addPatient(patient3);
                doctor8.addPatient(patient4);
                doctor8.addPatient(patient5);

                doctor9.addPatient(patient6);
                doctor9.addPatient(patient7);
                doctor9.addPatient(patient8);
                doctor9.addPatient(patient9);
                doctor9.addPatient(patient10);

        }

        public static void testHCC2() {

                LabHub labHub = LabHub.getInstance();
                HealthCareCenterManager hcc = HealthCareCenterManager.getInstance(labHub);

                PatientManager pm = PatientManager.getInstance();
                Patient patient1 = pm.createPatient("John Doe", "555-9876", "john.doe@example.com");
                Patient patient2 = pm.createPatient("Jane Doe", "555-9877", "jane.doe@example.com");

                hcc.addPatient(patient1);
                hcc.addPatient(patient2);

                DoctorManager dm = DoctorManager.getInstance();
                ServiceManager sm = ServiceManager.getInstance();

                Service service1 = sm.createService(ServiceType.CARDIO, "414414414", "email@email.com");
                Service service2 = sm.createService(ServiceType.GASTRO, "222222222", "email@email.com");
                Service service3 = sm.createService(ServiceType.NEPHRO, "444444444", "email@email.com");

                Doctor doctor1 = dm.createDoctor("1234", service1, "Jean Bon", "555-555-5555", "jean@bon.com");
                Doctor doctor2 = dm.createDoctor("3333", service2, "Doc 1", "555-333-5555", "doc@doc.com");
                Doctor doctor3 = dm.createDoctor("4444", service3, "Doc 2", "555-222-5555", "doc3@bon.com");
                doctor1.addPatient(patient1);
                doctor1.addPatient(patient2);
                doctor2.addPatient(patient2);
                doctor3.addPatient(patient1);

                service1.addDoctor(doctor1);
                service2.addDoctor(doctor2);
                service3.addDoctor(doctor3);

                hcc.addDoctor(doctor1);
                hcc.addDoctor(doctor2);
                hcc.addDoctor(doctor3);
                hcc.addService(service1);
                hcc.addService(service2);
                hcc.addService(service3);

                System.out.println(hcc);

                ExamAbstractFactory factory = new ExamFactory();
                Exam bloodAnalysis = factory.createElementaryExam(ElementaryExamType.BLOOD, "Base");
                Exam myelo = factory.createElementaryExam(ElementaryExamType.MYELO);
                Exam comp = factory.createCompositeExam(CompositeExamType.THYROID);
                Exam noav = factory.createElementaryExam(ElementaryExamType.TESTNOAV);

                PrescriptionManager presm = PrescriptionManager.getInstance();
                Prescription prescription1 = presm.createPrescription(patient1.getId(), bloodAnalysis);
                Prescription prescription2 = presm.createPrescription(patient1.getId(), myelo);
                Prescription prescription3 = presm.createPrescription(patient2.getId(), comp);
                Prescription prescription4 = presm.createPrescription(patient2.getId(), noav);

                AppointmentManager am = AppointmentManager.getInstance();
                AppointmentRequest request1 = am.createAppointmentRequest(prescription1);
                AppointmentRequest request2 = am.createAppointmentRequest(prescription2);
                AppointmentRequest request3 = am.createAppointmentRequest(prescription3);
                AppointmentRequest request4 = am.createAppointmentRequest(prescription4);

                System.out.println("\n");
                hcc.sendAppointmentRequest(request1);
                System.out.println("\n");
                hcc.sendAppointmentRequest(request2);
                System.out.println("\n");
                hcc.sendAppointmentRequest(request3);
                System.out.println("\n");
                hcc.sendAppointmentRequest(request4);

        }

}
