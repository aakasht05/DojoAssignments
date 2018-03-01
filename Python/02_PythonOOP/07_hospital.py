class Patient(object):
    count = 0
    def __init__(self, name, allergies):
        self.name = name
        self.allergies = allergies
        self.id = Patient.count
        self.bed_num = None
        Patient.count += 1

class Hospital(object):
    def __init__(self, name, cap):
        self.name = name
        self.cap = cap
        self.patients = []
        self.beds = self.initialize_beds()

    def initialize_beds(self):
        beds = []
        for i in range(0, self.cap):
            beds.append({
                "bed_id": i,
                "Available": True
            })
        return beds

    def admit(self, patient):
        if len(self.patients) <= self.cap:
            self.patients.append(patient)
            for i in range(0, len(self.beds)):
                if self.beds[i]["Available"]:
                    patient.bed_num = self.beds[i]["bed_id"]
                    self.beds[i]["Available"] = False
                    break
            print "Patient #{} admitted to bed #{}".format(patient.id, patient.bed_num)
        else:
            "Hospital is at full capacity"
    def discharge(self, patient_id):
        for patient in self.patients:
            if patient.id == patient_id:
                # free up bed
                for bed in self.beds:
                    if bed["bed_id"] == patient.bed_num:
                        bed["Available"] = True
                        break

                self.patients.remove(patient)
                return "Patient #{} sucessfully discharged.  Bed #{} now available".format(patient.id, patient.bed_num)
        return "Patient not found"

patient1 = Patient("John Smith", "peanut")
patient2 = Patient("John Oliver", "pollen")
patient3 = Patient("Jon Lennon", "pennecilin")
hospital1 = Hospital("Brookdale", 2)
hospital1.admit(patient1)
hospital1.admit(patient2)
hospital1.discharge(0)
hospital1.admit(patient3)


   