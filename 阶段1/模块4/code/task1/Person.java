package task1;

public class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }

    public Person(String name, int age){

        try {
            setAge(age);
        } catch (AgeException e) {
            e.printStackTrace();
        }
        try {
            setName(name);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException {
        if (null == name || "".equals(name))
            throw new java.lang.NullPointerException("姓名为空");
        else this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (18 <= age && age<=150)
            this.age = age;
        else
            throw new AgeException("年龄位于18到150岁之间。");
    }


}
