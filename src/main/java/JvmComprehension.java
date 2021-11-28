public class JvmComprehension {
    // JVM загружает класс JvmComprehension в систему ClassLoader в область памяти Metaspace
    public static void main(String[] args) {
        // В момент вызова метода main создается фрейм в стеке

        int i = 1;                      // Во фрейме main создается переменная i со значением 1.
        Object o = new Object();        // В куче создается экземпляр класса Оbject, во фрейме метода main создается переменная o, которой присваивается адрес ссылки на объект Оbject
        Integer ii = 2;                 // В куче создается объект Integer со значением 2, во фрейме main создается переменная ii со ссылкой на этот объект
        printAll(o, i, ii);             // Создается фрейм в стеке для функции printAll, в котором записываются переменные o, i, ii
        System.out.println("finished"); // 7 Создастся фрейм println в стеке, которому передается ссылка на созданный в куче объект String со значением "finished".
        // Если сборщик мусора запустится, он соберет переменную "finished"
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // В куче создается объект Integer со значением 700, во фрейме printAll создается переменная uselessVar со ссылкой на этот объект
        System.out.println(o.toString() + i + ii);  // Создастся фрейм println в стеке, куда передаются ссылки на переменные o, i, ii
        // В стеке созается фрейм toString. В него прописывается адрес выхода в println, переменная типа String для передачи возвращаемого значения в println и ссылка o
    }
}
