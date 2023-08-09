import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static List<Person> studants = new ArrayList<>();

    public static void main(String[] args) {

        boolean exit = true;
        while (exit){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Seleciona a opção");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Remover");
            System.out.println("4 - Editar");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            int option = scanner.nextInt();

            switch (option){
                case 1 :
                    addStudant(studants);
                    break;

                case 2 :
                    System.out.println("Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudant(studants, nameToFind);
                    break;

                case 3 :
                    removeStudant();
                    break;

                case 4 :
                    editStudant();
                    break;

                case 5 :
                    listAll();
                    break;

                case 6 :
                    exit = false;
                    break;
            }
        }
    }

    private static void removeStudant(){
        System.out.println("Qual o nome que deseja remover?");
        String name = scanner.next();
        Integer position = findStudant(studants, name);
        if (position != null){
            studants.remove(position.intValue());
        }

    }

    private static void editStudant(){
        System.out.println("Qual o nome que deseja editar?");
        String name = scanner.next();
        Integer position = findStudant(studants, name);
        if (position != null){
            Person p1 = studants.get(position.intValue());
            System.out.println("Qual e o novo nome?");
            name = scanner.next();
            p1.name = name;
        }
    }
    private static void addStudant(List<Person> studants){
        Person studant = new Person();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo do estudante");
        studant.name = scanner.nextLine();
        studants.add(studant);
        System.out.println("Obrigado por digitar o nome completo do " + studant.name);
    }

    private static void listAll(){
        int countM = 0;
        int countF = 0;

        for (Person p : studants){
            System.out.println(p.name);
        }
        //studants.forEach(p -> {
         //   System.out.println(p.name);
       // });

        //for(int i = 0; i < studants.size(); i++){
        //  if (studants.get(i).sexo.equals("Masculino ")){
        //    countM++;
        //}else{
        //      countF++;
         //  }
           }
        //System.out.println("Masculino: " +  countM + "Feminino: " + countF);
       //  }


    private static Integer findStudant(List<Person> studants, String studantName) {
        Integer position = null;
        for(int count = 0; count < studants.size(); count++){
            Person student = studants.get(count);
            if(student.name.equals(studantName)){
                position = count;
                System.out.println("Encontrei o " + studantName);

            }
        }
        return position;
    }
}