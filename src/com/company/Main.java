package com.company;

class Student {
    private String name;    //Estos son modificadores de acceso ---> Encapsulamiento
    private String lastName;
    private String code;

    //Constructores:
    Student(String name, String lastName, String code) {   //tiene que llamarse igual a la clase a la que pertenece, puede o no recibir parámetros y no tiene retorno
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }

    //Getters
    public String getName() {
        return name;   //En este tambien se puede usar this.name pero en este caso no es necesario
    }

    public String getlastName() {
        return lastName;
    }

    public String getCode() {
        return code;
    }

    //Impresion
    public void printStudent(Student student){
        System.out.println(student.getCode() + ": " + student.getName() + " " + student.getlastName());
    }
}


    class Group{
        private String code;  //tiene null
        private Student[] students;  //tiene null
        private int enrolled;  //tiene 0.   Todos los int, float, short, byte, double, char se inicializan con 0
                            //booleanos se inicializan con false
        private int rejected;

        //Constructor
        public Group(String code, int capacity) {
            this.code = code;
            students = new Student[capacity];
        }

        //Add & remove
        public boolean addStudent(Student student){
            if(enrolled < students.length){   //length es el tamaño del arreglo
                students[enrolled++] = student;   //hortogonalidad
                return true;
            } //sino sigue en la siguiente línea

            System.out.println("Este estudiante no fue añadido: " + student.getName() + " " + student.getlastName() ); //YA NO HAY CUPO ;(
            rejected++;
            return false;
        }

        public void removeStudent(String code){
            for(int i = 0; i < enrolled; i++){   //recorre la lista
                if(code == students[i].getCode()){  //si encuentra el code
                    for(int k = i; k < enrolled-1; k++){  //enrolled -1 para que el ultimo dato se pierda
                        students[k] = students[k+1];  //Recorre los datos eliminando así el que se debe de eliminar
                    }
                    enrolled--;   //disminuye la lista ya que se eliminó el dato
                }
            }
        }

        //Getters
        public String getCode(){
            return code;
        }

        public int getEnrolled(){
            return enrolled;
        }

        public int getRejected(){
            return rejected;
        }

        public Student getStudent(int index){
            return students[index];
        }

        //Impresion
        public void printGroup(Group group){
            System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());

            if(enrolled != 0){
                System.out.println("LISTA DE ALUMNOS INSCRITOS: " );
                for(int i = 0; i < enrolled; i++) {
                    students[i].printStudent(students[i]);
            }
            }
        }

    }



    public class Main {

        public static void main(String[] args) {
            //Creación alumnos
            Student student1; // Referencia a un la clase Student
            Student student2 = new Student("Marco", "Lopez", "305350"); //Referencia y creación de un objeto alumno
            student1 = new Student("Diego", "Lopez", "321450"); // Creando un objeto alumno

            //Creación grupos
            Group group = new Group("230401", 8); //Referencia y Crea un objeto grupo
            Group group2 = new Group("230402", 6);

            //Adición de alumnos a grupos
            group.addStudent(student1);
            group.addStudent(student2);

            group.addStudent(new Student("Jorge", "Acosta", "1"));
            group.addStudent(new Student("Arturo", "Aleman", "2"));
            group.addStudent(new Student("Antonio", "Angel", "3"));
            group.addStudent(new Student("Francisco", "Arreguin", "4"));
            group2.addStudent(new Student("Misael", "Cabrera", "5"));
            group2.addStudent(new Student("Roberto", "Cisneros", "6"));
            group.addStudent(new Student("Juan", "Coronado", "7"));
            group.addStudent(new Student("José", "González", "8"));
            group.addStudent(new Student("Jesús", "Lara", "9"));
            group.addStudent(new Student("José", "Limón", "10"));

            //Impresion grupos
            System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
            System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

            //Eliminación de alumnos
            group.removeStudent("4");
            group2.removeStudent("6");
            group2.removeStudent("12");

            //Impresion grupos
            System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
            System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

            System.out.println();

            //Impresion estudiantes
            System.out.println("Alumnos del grupo: " + group.getCode());

            for (int i = 0; i < group.getEnrolled(); i++) {
                Student student = group.getStudent(i);
                System.out.println(student.getCode() + ": " + student.getName() + " " + student.getlastName());
            }

            System.out.println();
            System.out.println("Alumnos del grupo: " + group2.getCode());

            for (int i = 0; i < group2.getEnrolled(); i++) {
                Student student = group2.getStudent(i);
                System.out.println(student.getCode() + ": " + student.getName() + " " + student.getlastName());
            }

            System.out.println();
            System.out.println("---------------------------------------------");
            System.out.println();

            System.out.println("2) IMPRESION DE GRUPOS Y ESTUDIANTES ");

            group.printGroup(group); //se ve raro que mande el grupo como parámetro al mismo grupo pero me funcionó :)
            System.out.println();
            group2.printGroup(group2);  //aquí también xd

        }
    }