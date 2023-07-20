package EmployeeManagementSystem;

import java.util.*;

public class GetSetEmployee 
{
    private String name;
    private int age;
    private Date dateOfHired;
    private String email;
    private String address;
    private String phone;
    private String employeeId;
    private String education;
    private String position;
    private int salary;
    private String department;
    private Date date;
    private String manager;
    private boolean workToFullPotential;
    private boolean workConsistency;
    private boolean qualityOfWork;
    private boolean goodCommunication;
    private boolean takesInitiative;
    private boolean creativity;
    private boolean reliability;
    private boolean productivity;
    private boolean technicalSkills;
    private boolean efficiency;
    private boolean teamwork;
    private boolean leadership;
    private boolean independentWork;
    private boolean punctuality;
    private String overallReview;
    private String areaOfImprovement;
    private String comment;
    private int requestId;
    private int totalHours;
    private Date dateOfAbsenceFrom;
    private Date dateOfAbsenceTo;
    private boolean vacation;
    private boolean medicalLeave;
    private boolean juryDuty;
    private boolean personalLeave;
    private boolean familyReasons;
    private boolean toVote;
    private boolean bereavement;
    private boolean timeOffWithoutPay;
    private String reasonForRequest;
    private String employeeSignature;
    private Date requestDate;
    private String status;
    private String login, passWord;
    
    public GetSetEmployee(String employeeId, String name, String department, String manager, int totalHours, Date dateOfAbsenceFrom, Date dateOfAbsenceTo, boolean vacation, boolean medicalLeave, boolean juryDuty, boolean personalLeave, boolean familyReasons, boolean toVote, boolean bereavement, boolean timeOffWithoutPay, Date requestDate, String reasonForRequest, String employeeSignature) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.manager = manager;
        this.totalHours = totalHours;
        this.dateOfAbsenceFrom = dateOfAbsenceFrom;
        this.dateOfAbsenceTo = dateOfAbsenceTo;
        this.requestDate = requestDate;
        this.reasonForRequest = reasonForRequest;
        this.employeeSignature = employeeSignature;
        this.vacation = vacation;
        this.medicalLeave = medicalLeave;
        this.juryDuty = juryDuty;
        this.personalLeave = personalLeave;
        this.familyReasons = familyReasons;
        this.toVote = toVote;
        this.bereavement = bereavement;
        this.timeOffWithoutPay = timeOffWithoutPay;
    }
    
    public GetSetEmployee(String login, String passWord) {
        this.login = login;
        this.passWord = passWord;
    }


    public GetSetEmployee(String name, int age, Date dateOfHired, String email, String address, String phone, String employeeId, String education, String position, int salary, String department) 
    {
        this.name = name;
        this.age = age;
        this.dateOfHired = dateOfHired;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.employeeId = employeeId;
        this.education = education;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }
    
    public GetSetEmployee(String name, int age, String department, String position, int salary, String address, String email, String phone)
    {
        this.name = name;
        this.age = age;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.address = address;
        this.email = email;
        this.phone = phone;
        
    }
    
    public GetSetEmployee(String name, String position, String manager, Date date, String department, String employeeId, boolean workToFullPotential, boolean workConsistency,
                               boolean qualityOfWork, boolean goodCommunication, boolean takesInitiative, boolean creativity, boolean reliability, boolean productivity, boolean technicalSkills, 
                               boolean efficiency, boolean teamwork, boolean leadership, boolean independentWork, boolean punctuality, String areaOfImprovement, String comment, String overallReview)
    {
        this.name = name;
        this.position = position;
        this.manager = manager;
        this.date = date;
        this.department = department;
        this.employeeId = employeeId;
        this.workToFullPotential = workToFullPotential;
        this.workConsistency = workConsistency;
        this.qualityOfWork = qualityOfWork;
        this.goodCommunication = goodCommunication;
        this.takesInitiative = takesInitiative;
        this.creativity = creativity;
        this.reliability = reliability;
        this.productivity = productivity;
        this.technicalSkills = technicalSkills;
        this.efficiency = efficiency;
        this.teamwork = teamwork;
        this.leadership = leadership;
        this.independentWork = independentWork;
        this.punctuality = punctuality;
        this.areaOfImprovement = areaOfImprovement;
        this.comment = comment;
        this.overallReview = overallReview;
  
    }
    
    public GetSetEmployee(String employeeId, String name, String position, String manager, Date date, String department, boolean workToFullPotential, boolean workConsistency, boolean qualityOfWork, boolean goodCommunication, boolean takesInitiative, boolean creativity, boolean reliability, boolean productivity, boolean technicalSkills, boolean efficiency, boolean teamwork, boolean leadership, boolean independentWork, boolean punctuality, String areaOfImprovement, String comment, String overallReview)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.manager = manager;
        this.date = date;
        this.department = department;
        this.workToFullPotential = workToFullPotential;
        this.workConsistency = workConsistency;
        this.qualityOfWork = qualityOfWork;
        this.goodCommunication = goodCommunication;
        this.takesInitiative = takesInitiative;
        this.creativity = creativity;
        this.reliability = reliability;
        this.productivity = productivity;
        this.technicalSkills = technicalSkills;
        this.efficiency = efficiency;
        this.teamwork = teamwork;
        this.leadership = leadership;
        this.independentWork = independentWork;
        this.punctuality = punctuality;
        this.areaOfImprovement = areaOfImprovement;
        this.comment = comment;
        this.overallReview = overallReview;
  
    }
    
    public GetSetEmployee()
    {
       
    }
    
    public String getLogIn() {
        return login;
    }
    
     public String getPass() {
        return passWord;
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public Date getDateOfHired() 
    {
        return dateOfHired;
    }

    public void setDateOfHired(Date dateOfHired) 
    {
        this.dateOfHired = dateOfHired;
    }
    
    public Date getDate() 
    {
        return date;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getEmployeeId() 
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public String getEducation() 
    {
        return education;
    }

    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getPosition() 
    {
        return position;
    }

    public void setPosition(String position) 
    {
        this.position = position;
    }

    public int getSalary() 
    {
        return salary;
    }

    public void setSalary(int salary) 
    {
        this.salary = salary;
    }

    public String getDepartment() 
    {
        return department;
    }

    public void setDepartment(String department) 
    {
        this.department = department;
    }
    
    public String getManager() 
    {
        return manager;
    }

    public void setManager(String manager) 
    {
        this.manager = manager;
    }
    
    public boolean isWorkToFullPotential() 
    {
        return workToFullPotential;
    }

    public void setWorkToFullPotential(boolean workToFullPotential) 
    {
        this.workToFullPotential = workToFullPotential;
    }

    public boolean isWorkConsistency() 
    {
        return workConsistency;
    }

    public void setWorkConsistency(boolean workConsistency) 
    {
        this.workConsistency = workConsistency;
    }

    public boolean isQualityOfWork() 
    {
        return qualityOfWork;
    }

    public void setQualityOfWork(boolean qualityOfWork) 
    {
        this.qualityOfWork = qualityOfWork;
    }
    
    public boolean isGoodCommunication() 
    {
        return goodCommunication;
    }

    public void setGoodCommunication(boolean goodCommunication) 
    {
        this.goodCommunication = goodCommunication;
    }

    public boolean isTakesInitiative() 
    {
        return takesInitiative;
    }

    public void setTakesInitiative(boolean takesInitiative) 
    {
        this.takesInitiative = takesInitiative;
    }

    public boolean isCreativity() 
    {
        return creativity;
    }

    public void setCreativity(boolean creativity) 
    {
        this.creativity = creativity;
    }
    
    public boolean isReliability() 
    {
        return reliability;
    }

    public void setReliability(boolean reliability) 
    {
        this.reliability = reliability;
    }

    public boolean isProductivity() 
    {
        return productivity;
    }

    public void setProductivity(boolean productivity) 
    {
        this.productivity = productivity;
    }

    public boolean isTechnicalSkills() 
    {
        return technicalSkills;
    }

    public void setTechnicalSkills(boolean technicalSkills) 
    {
        this.technicalSkills = technicalSkills;
    }

    public boolean isEfficiency() 
    {
        return efficiency;
    }

    public void setEfficiency(boolean efficiency) 
    {
        this.efficiency = efficiency;
    }
    
    public boolean isTeamwork() 
    {
        return teamwork;
    }

    public void setTeamwork(boolean teamwork) 
    {
        this.teamwork = teamwork;
    }

    public boolean isLeadership() 
    {
        return leadership;
    }

    public void setLeadership(boolean leadership) 
    {
        this.leadership = leadership;
    }

    public boolean isIndependentWork() 
    {
        return independentWork;
    }

    public void setIndependentWork(boolean independentWork) 
    {
        this.independentWork = independentWork;
    }

    public boolean isPunctuality() 
    {
        return punctuality;
    }

    public void setPunctuality(boolean punctuality) 
    {
        this.punctuality = punctuality;
    }
    
    public String getAreaOfImprovement() 
    {
        return areaOfImprovement;
    }

    public void setAreaOfImprovement(String areaOfImprovement) 
    {
        this.areaOfImprovement = areaOfImprovement;
    }

    public String getComment() 
    {
        return comment;
    }

    public void setComment(String comment) 
    {
        this.comment = comment;
    }
    
    public String getOverallReview() 
    {
        return overallReview;
    }

    public void setOverallReview(String overallReview) 
    {
        this.overallReview = overallReview;
    }
    
    public int getRequestId() 
    {
        return requestId;
    }

    public void setRequestId(int requestId) 
    {
        this.requestId = requestId;
    }
    
    public int getTotalHours() 
    {
        return totalHours;
    }

    public void setTotalHours(int totalHours) 
    {
        this.totalHours = totalHours;
    }

    public Date getDateOfAbsenceFrom() 
    {
        return dateOfAbsenceFrom;
    }

    public void setDateOfAbsenceFrom(Date dateOfAbsenceFrom) 
    {
        this.dateOfAbsenceFrom = dateOfAbsenceFrom;
    }

    public Date getDateOfAbsenceTo() 
    {
        return dateOfAbsenceTo;
    }

    public void setDateOfAbsenceTo(Date dateOfAbsenceTo) 
    {
        this.dateOfAbsenceTo = dateOfAbsenceTo;
    }
    
    public boolean isVacation() {
        return vacation;
    }

    public void setVacation(boolean vacation) 
    {
        this.vacation = vacation;
    }

    public boolean isMedicalLeave() 
    {
        return medicalLeave;
    }

    public void setMedicalLeave(boolean medicalLeave) 
    {
        this.medicalLeave = medicalLeave;
    }

    public boolean isJuryDuty() 
    {
        return juryDuty;
    }

    public void setJuryDuty(boolean juryDuty) 
    {
        this.juryDuty = juryDuty;
    }
    
    public boolean isPersonalLeave() 
    {
        return personalLeave;
    }

    public void setPersonalLeave(boolean personalLeave) 
    {
        this.personalLeave = personalLeave;
    }

    public boolean isFamilyReasons() 
    {
        return familyReasons;
    }

    public void setFamilyReasons(boolean familyReasons) 
    {
        this.familyReasons = familyReasons;
    }

    public boolean isToVote() 
    {
        return toVote;
    }

    public void setToVote(boolean toVote) 
    {
        this.toVote = toVote;
    }

    public boolean isBereavement() 
    {
        return bereavement;
    }

    public void setBereavement(boolean bereavement) 
    {
        this.bereavement = bereavement;
    }
    
    public boolean isTimeOffWithoutPay() 
    {
        return timeOffWithoutPay;
    }

    public void setTimeOffWithoutPay(boolean timeOffWithoutPay) 
    {
        this.timeOffWithoutPay = timeOffWithoutPay;
    }

    public String getReasonForRequest() 
    {
        return reasonForRequest;
    }

    public void setReasonForRequest(String reasonForRequest) 
    {
        this.reasonForRequest = reasonForRequest;
    }

    public String getEmployeeSignature() 
    {
        return employeeSignature;
    }

    public void setEmployeeSignature(String employeeSignature) {
        this.employeeSignature = employeeSignature;
    }

    public Date getRequestDate() 
    {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) 
    {
        this.requestDate = requestDate;
    }
    
    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }
}
