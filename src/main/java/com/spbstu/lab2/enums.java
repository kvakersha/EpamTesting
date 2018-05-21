package com.spbstu.lab2;

public enum enums {
    Site("https://jdi-framework.github.io/tests/index.htm"),
    Title("Index Page"),
    Login("epam"),
    Password("1234"),
    UserName("PITER CHAILOVSKII"),
    actualIconsNumber(4),
    texts(new String[] {"To include good practices\nand ideas from successful\nEPAM projec", "To be flexible and\ncustomizable", "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}),
    MainHeader("EPAM FRAMEWORK WISHES…"),
    HomePage("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    String[] text;
    String value;
    Integer val;
    enums(String str){
        value = str;
    }
    enums(Integer i){
        val = i;
    }
    enums(String[] i){
        text = i;
    }
}
