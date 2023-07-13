package dataobjects;

public class DataAssignLeave {
    private String employeeName;
    private String leaveType;
    private String fromDate;
    private String toDate;


    public DataAssignLeave(String employeeName, String leaveType, String fromDate, String toDate) {
        this.employeeName = employeeName;
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }
}
