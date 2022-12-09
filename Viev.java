public interface Viev {
    String getData(String message);
    void printData(String message, boolean ifNewLine);
    //название переменной ifNewLine можно заменить, или интерпретировать иначе
    //например, вывод какой-либо информации должен осуществаляться в каком либо окне
    //если речь идёт о каком-то графическом интерфейсе, например.
}