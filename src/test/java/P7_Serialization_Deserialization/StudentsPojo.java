package P7_Serialization_Deserialization;

public class StudentsPojo
{
    String Id;
    String Name;
    String Location;
    String Phone;
    String [] Courses ;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String[] getCourses() {
        return Courses;
    }

    public void setCourses(String[] courses) {
        Courses = courses;
    }


}
