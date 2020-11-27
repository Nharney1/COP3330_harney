public class People {

    private String name;
    private String ID;
    private String Job;

    public People(String name, String ID, String Job){
        this.name = name;
        this.ID = ID;
        this.Job = Job;
    }

    @Override
    public String toString(){
        return (name + " " + ID + " " + Job + "\n");
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }


}
