package map.treemap;

import java.util.*;


public class TreeMapRunner {
    public static void main(String[] args) {

        //grades это map, которые возвращает метод createGrades()
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = createGrades();
        printGrades(grades, true);


        AverageStudentGrade border = grades.ceilingKey(new AverageStudentGrade("", 80));
        //студенты, которые находятся ниже границы (оцеки которых выше)
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> scholarshipStudents = grades.tailMap(border);

        System.out.println("==========================");
        System.out.println("\nScholarship students");
        printGrades(scholarshipStudents, false);

        System.out.println("\nContender student");

        AverageStudentGrade contender = grades.lowerKey(border);
        System.out.println(contender);

//        AverageStudentGrade border = grades.ceilingKey(new AverageStudentGrade("", 80));

        //NavigableMap позволяет использовать метод descendingMap(), который выводит map в обратном порядке - от больших оценок к меньшим. поэтому SortedMap преобразуем к NavigableMap
//        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> scholarshipStudents = (NavigableMap<AverageStudentGrade, Set<SubjectGrade>>) grades.tailMap(border);
//        System.out.println("================================================");
//        System.out.println("Scholarship students");
//        printGrades(scholarshipStudents.descendingMap(), false);
//        System.out.println("Contender");
//        AverageStudentGrade contender = grades.lowerKey(border);
//        System.out.println(contender);

    }

    private static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades() {
        //инициализируем HashSet (для одного студента - Алекса) (сеты содержат одно значение - не пару). данный сет заполняется объектами типа SubjectGrade. у объекта 2 поля: предмет и оценка.
        Set<SubjectGrade> alexGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Mathematics", 89));
        alexGrades.add(new SubjectGrade("Physics", 65));
        alexGrades.add(new SubjectGrade("History", 95));
        alexGrades.add(new SubjectGrade("Literature", 90));
        alexGrades.add(new SubjectGrade("Chemistry", 75));

        //инициализируем HashSet (для одного студента - James)
        Set<SubjectGrade> jamesGrades = new HashSet<>();
        jamesGrades.add(new SubjectGrade("Mathematics", 75));
        jamesGrades.add(new SubjectGrade("Physics", 80));
        jamesGrades.add(new SubjectGrade("History", 55));
        jamesGrades.add(new SubjectGrade("Literature", 70));
        jamesGrades.add(new SubjectGrade("Chemistry", 80));

        //инициализируем HashSet (для одного студента - Antony)
        Set<SubjectGrade> antonyGrades = new HashSet<>();
        antonyGrades.add(new SubjectGrade("Mathematics", 93));
        antonyGrades.add(new SubjectGrade("Physics", 91));
        antonyGrades.add(new SubjectGrade("History", 82));
        antonyGrades.add(new SubjectGrade("Literature", 78));
        antonyGrades.add(new SubjectGrade("Chemistry", 88));

        //инициализируем HashSet (для одного студента - Victoria)
        Set<SubjectGrade> victoriaGrades = new HashSet<>();
        victoriaGrades.add(new SubjectGrade("Mathematics", 73));
        victoriaGrades.add(new SubjectGrade("Physics", 65));
        victoriaGrades.add(new SubjectGrade("History", 75));
        victoriaGrades.add(new SubjectGrade("Literature", 66));
        victoriaGrades.add(new SubjectGrade("Chemistry", 50));

        //инициализируем HashSet (для одного студента - Alina)
        Set<SubjectGrade> alinaGrades = new HashSet<>();
        alinaGrades.add(new SubjectGrade("Mathematics", 95));
        alinaGrades.add(new SubjectGrade("Physics", 99));
        alinaGrades.add(new SubjectGrade("History", 94));
        alinaGrades.add(new SubjectGrade("Literature", 97));
        alinaGrades.add(new SubjectGrade("Chemistry", 95));


        //создаем map (содержит пару значений). первое значение - объект AverageStudentGrade (name, averageGrade) - имя и средняя оценка студента. Средняя оценка рассчитывается в методе calcAverage(Set<SubjectGrade> grades) ниже.
        //вторым параметром в map передается Set<SubjectGrade> - набор из предметов и оценок для каждого студента, который был определен выше.
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new AverageStudentGrade("Alex", calcAverage(alexGrades)), alexGrades);
        map.put(new AverageStudentGrade("James", calcAverage(jamesGrades)), jamesGrades);
        map.put(new AverageStudentGrade("Antony", calcAverage(antonyGrades)), antonyGrades);
        map.put(new AverageStudentGrade("Victoria", calcAverage(victoriaGrades)), victoriaGrades);
        map.put(new AverageStudentGrade("Alina", calcAverage(alinaGrades)), alinaGrades);

        return map;

    }

    private static void printGrades(Map<AverageStudentGrade, Set<SubjectGrade>> map, boolean printValue) {
        Set<AverageStudentGrade> keys = map.keySet();

        for (AverageStudentGrade key: keys) {
            System.out.println(key);
            if (printValue) {
                System.out.println(map.get(key));
            }
        }

    }


    // метод для рассчета средней оценки (из всех предметов) для каждого студента. на входе сут объектов SubjectGrade
    private static float calcAverage(Set<SubjectGrade> grades) {

        float sum = 0;
        for (SubjectGrade sg: grades) {
            sum +=sg.getGrade();
        }
        return sum / grades.size();

    }
}
