package Caser;
import Caser.State;
import java.util.ArrayList;

public class Analisator {
    public static String analyse(String string){
        String eMessage="";
        char c;
        State state=State.S;
        ArrayList<CaserConst> consts=new ArrayList<>();
        ArrayList<CaserId> ids=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<string.length()&state!=State.E;i++){
            c=string.toLowerCase().charAt(i);
            switch (state){
                case S:
                    switch (c){
                        case ' ':
                            state=State.S;
                            break;
                        case 'c':
                            state=State.A1;
                            break;
                        default: eMessage="ошибка в слове case";return eMessage;
                    }
                    break;
                case A1:
                    switch (c){
                        case 'a':
                            state=State.A2;
                            break;
                        default: eMessage="ошибка в слове case";return eMessage;
                    }
                    break;
                case A2:
                    switch (c){
                        case 's':
                            state=State.A3;
                            break;
                        default: eMessage="ошибка в слове case";return eMessage;
                    }
                    break;
                case A3:
                    switch (c){
                        case 'e':
                            state=State.A4;
                            break;
                        default: eMessage="ошибка в слове case";return eMessage;
                    }
                    break;
                case A4:
                    switch (c){
                        case ' ':
                            state=State.A5;
                            break;
                        default: eMessage="отсутствует пробел после case";return eMessage;
                    }
                    break;
                /*
                 * id analyse begin
                 * */
                case A5:
                    switch (c){
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A6;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в id на позиции "+i;return "e"+eMessage;
                    }break;
                case A6:
                    switch (c){
                        case'_': case'0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A6;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A7;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в id на позиции "+i;return "e"+eMessage;

                    }break;
                case A7:
                    switch (c){
                        case ' ':
                            state=State.A7;break;
                        case 'o':
                            state=State.A8;break;
                            default:eMessage="слово of не обнаружено";return eMessage;
                    }
                    break;
                case A8:
                    switch (c){
                        case 'f':
                            state=State.A9;break;
                        default:eMessage="ошибка в слове of";return eMessage;
                    }
                    break;
                case A9:
                    switch (c){
                        case ' ':
                            state=State.A10;break;
                        default:eMessage="после слова of необходм пробел";return eMessage;
                    }
                    break;
                case A10:
                    switch (c){
                        case'\\': case' ':
                            state=State.A10;break;
                        case'\'':
                            state=State.A11;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append("\'");
                            break;
                        case '-':
                            state=State.A14;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append("-");
                            break;
                        case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state=State.A17;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '0':
                            state=State.A16;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append("0");
                            break;
                        default:eMessage="ошибка в константе на позиции "+i;return "e"+eMessage;
                    }
                    break;
                case A11:
                    switch (c){
                        case '\'':
                            state=State.A13;
                            stringBuilder.append("\'");
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:
                            state=State.A11;
                            stringBuilder.append(string.charAt(i));
                    }
                    break;
                //fiction
                case A12:
                    break;
                case A13:
                    switch (c){
                        case ',':
                            state=State.A10;break;
                        case ' ':
                            state=State.A15;break;
                        case ';':
                            state=State.A23;break;
                        default:eMessage="недопустимый символ после константы на позиции "+i;return "e"+eMessage;
                    }break;
                case A14:
                    switch (c){
                        case '0':
                            state=State.A16;
                            stringBuilder.append("0");
                            break;
                        case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state=State.A17;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в константе на позиции "+i;return "e"+eMessage;
                    }break;
                case A15:
                    switch (c){
                        case ',':
                            state=State.A10;break;
                        case ' ':
                            state=State.A15;break;
                        case ':':
                            state=State.A23;break;
                        default:eMessage="недопустимый символ после константы на позиции "+i;return "e"+eMessage;
                    }break;
                case A16:
                    switch (c){
                        case ',':
                            state=State.A10;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case ' ':
                            state=State.A15;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case '.':
                            state=State.A20;
                            stringBuilder.append(".");
                            break;
                        default:eMessage="недопустимый символ после константы на позиции "+i;return "e"+eMessage;
                    }break;
                case A17:
                    switch (c){
                        case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state=State.A17;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '.':
                            state=State.A20;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case 'e':
                            state=State.A19;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ':':
                            state=State.A23;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case ',':
                            state=State.A10;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case ' ':
                            state=State.A15;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:eMessage="\"ошибка в константе на позиции "+i;return "e"+eMessage;
                    }break;
                case A18:
                    switch (c){
                        case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state=State.A18;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A15;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case ',':
                            state=State.A10;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case ':':
                            state=State.A23;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в константе на позиции "+i;return "e"+eMessage;
                    }break;
                case A19:
                    switch (c){
                        case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state=State.A18;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '-':
                            state=State.A22;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в константе на позиции "+i;return "e"+eMessage;
                    }break;
                case A20:
                    switch (c){
                        case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state=State.A21;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в константе на позиции "+i;return "e"+eMessage;
                    }break;
                case A21:
                    switch (c){
                        case ',':
                            state=State.A10;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case ':':
                            state=State.A23;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case 'e':
                            state=State.A19;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A15;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state=State.A21;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в константе на позиции "+i;return "e"+eMessage;
                    }break;
                case A22:
                    switch (c){
                        case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state=State.A18;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в константе на позиции "+i;return "e"+eMessage;
                    }break;
                case A23:
                    switch (c){
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A24;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A23;break;
                        default:eMessage="неверное выражение на позиции "+i;return "e"+eMessage;
                    }break;
                case A24:
                    switch (c){
                        case'_': case'0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A24;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ':':
                            state=State.A33;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case ' ':
                            state=State.A25;break;
                        case '[':
                            state=State.A26;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            stringBuilder=new StringBuilder();
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A25:
                    switch (c){
                        case ' ':
                            state=State.A25;break;
                        case '[':
                            state=State.A26;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            stringBuilder=new StringBuilder();
                            break;
                        case ':':
                            state=State.A33;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A26:
                    switch (c){
                        case ' ':
                            state=State.A26;break;
                        case '0':
                            state=State.A30;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '-':
                            state=State.A29;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A28;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A27;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A27:
                    switch (c){
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A27;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A31;

                            ids.add(new CaserId(stringBuilder.toString(),i));

                            break;
                        case ']':
                            state=State.A32;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A28:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A28;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A31;

                            consts.add(new CaserConst(stringBuilder.toString(),i));

                            break;
                        case ']':
                            state=State.A32;

                            consts.add(new CaserConst(stringBuilder.toString(),i));


                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A29:
                    switch (c){
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A28;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A30:
                    switch (c){
                        case ' ':
                            state=State.A31;

                            consts.add(new CaserConst(stringBuilder.toString(),i));

                            break;
                        case ']':
                            consts.add(new CaserConst(stringBuilder.toString(),i));

                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A31:
                    switch (c){
                        case ']':
                            state=State.A32;
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A32:
                    switch (c){
                        case ' ':
                            state=State.A32;
                            //ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case ':':
                            state=State.A33;
                            //ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A33:
                    switch (c){
                        case '=':
                            state=State.A34;break;
                        default:eMessage="ошибка в := в выражении на позиции "+i;return "e"+eMessage;
                    }break;
                case A34:
                    switch (c){
                        case ' ':
                            state=State.A34;break;
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A35;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A44;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '-':
                            state=State.A45;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '0':
                            state=State.A47;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A35:
                    switch (c){
                        case ' ':
                            state=State.A38;break;
                        case'_': case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A35;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '[':
                            state=State.A37;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '+': case '-': case '*': case '/':
                            state=State.A34;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case ';':
                            state=State.A10;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A36:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A36;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A42;break;
                        case ']':
                            state=State.A43;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A37:
                    switch (c){
                        case ' ':
                            state=State.A37;break;
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A36;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '-':
                            state=State.A41;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '0':
                            state=State.A40;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A39;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A38:
                    switch (c){
                        case ' ':
                            state=State.A38;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case '[':
                            state=State.A37;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '+': case '-': case '*': case '/':
                            state=State.A34;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case 'd':
                            state=State.A52;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case 'm':
                            state=State.A55;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case 'e':
                            state=State.A57;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A39:
                    switch (c){
                        case ' ':
                            state=State.A42;break;
                        case ']':
                            state=State.A43;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A39;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A40:
                    switch (c){
                        case ' ':
                            state=State.A42;break;
                        case ']':
                            state=State.A43;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A41:
                    switch (c){
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A36;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A42:
                    switch (c){
                        case ' ':
                            state=State.A42;break;
                        case ']':
                            state=State.A43;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A43:
                    switch (c){
                        case '+': case '-': case '*': case '/':
                            state=State.A34;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case ' ':
                            state=State.A51;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case ';':
                            state=State.A10;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A44:
                    switch (c){
                        case ';':
                            state=State.A10;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case '+': case '-': case '*': case '/':
                            state=State.A34;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A44;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case 'e':
                            state=State.A49;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '.':
                            state=State.A46;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A51;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A45:
                    switch (c){
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A44;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ';':
                            state=State.A10;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                        case '0':
                            state=State.A47;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A46:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A48;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A47:
                    switch (c){
                        case '.':
                            state=State.A46;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ';':
                            state=State.A10;
                            consts.add(new CaserConst(stringBuilder.toString(),i));break;

                        case '+': case '-': case '*': case '/':
                            state=State.A34;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;

                        case ' ':
                            state=State.A51;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;

                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A48:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A48;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ';':
                            state=State.A10;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;

                        case ' ':
                            state=State.A51;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;

                        case '+': case '-': case '*': case '/':
                            state=State.A34;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;

                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A49:
                    switch (c){
                        case '-':
                            state=State.A58;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A50;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A50:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A50;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ';':
                            state=State.A10;
                            consts.add(new CaserConst(stringBuilder.toString(),i));

                        case ' ':
                            state=State.A51;
                            consts.add(new CaserConst(stringBuilder.toString(),i));

                        case '+': case '-': case '*': case '/':
                            state=State.A34;
                            consts.add(new CaserConst(stringBuilder.toString(),i));

                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A51:
                    switch (c){
                        case 'e':
                            state=State.A57;break;
                        case ' ':
                            state=State.A51;break;
                        case '+': case '-': case '*': case '/':
                            state=State.A34;break;
                        case ';':
                            state=State.A10;break;
                        case 'd':
                            state=State.A52;break;
                        case 'm':
                            state=State.A55;break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A52:
                    switch (c){
                        case 'i':
                            state=State.A53;break;
                        default:eMessage="mistake in div";return eMessage;
                    }break;
                case A53:
                    switch (c){
                        case 'v':
                            state=State.A54;break;
                        default:eMessage="mistake in div";return eMessage;
                    }break;
                case A54:
                    switch (c){
                        case ' ':
                            state=State.A34;break;
                        default:eMessage="need space after key word";return eMessage;
                    }break;
                case A55:
                    switch (c){
                        case 'o':
                            state=State.A56;break;
                        default:eMessage="mistake in mod";return eMessage;
                    }break;
                case A56:
                    switch (c){
                        case 'd':
                            state=State.A54;break;
                        default:eMessage="mistake in mod";return eMessage;
                    }break;
                case A57:
                    switch (c){
                        case 'n':
                            state=State.A99;break;
                        case 'l':
                            state=State.A59;break;
                        default:eMessage="ошибка в ключевом слове на позиции "+i;return "e"+eMessage;
                    }break;
                case A58:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A50;break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A59:
                    switch (c){
                        case 's':
                            state=State.A60;break;
                        default:eMessage="ошибка в ключевом слове на позиции "+i;return "e"+eMessage;
                    }break;
                case A60:
                    switch (c){
                        case 'e':
                            state=State.A61;break;
                        default:eMessage="ошибка в ключевом слове на позиции "+i;return "e"+eMessage;
                    }break;
                case A61:
                    switch (c){
                        case ' ':
                            state=State.A62;break;
                        default:eMessage="ошибка в ключевом слове на позиции "+i;return "e"+eMessage;
                    }break;
                case A62:
                    switch (c){
                        case ' ':
                            state=State.A62;break;
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A63;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A63:
                    switch (c){
                        case'_':case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A63;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A64;break;
                        case '[':
                            state=State.A65;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            stringBuilder=new StringBuilder();
                            break;
                        case ':':
                            state=State.A73;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A64:
                    switch (c){
                        case ':':
                            state=State.A73;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case '[':
                            state=State.A65;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            stringBuilder=new StringBuilder();
                            break;
                        case ' ':
                            state=State.A64;break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A65:
                    switch (c){
                        case ' ':
                            state=State.A65;break;
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A66;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '0':
                            state=State.A67;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '-':
                            state=State.A68;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A69;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A66:
                    switch (c){
                        case ' ':
                            state=State.A70;

                            ids.add(new CaserId(stringBuilder.toString(),i));

                            break;
                        case'_':case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A66;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ']':
                            state=State.A71;

                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A67:
                    switch (c){
                        case'_':case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A66;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ']':
                            state=State.A71;
                            consts.add(new CaserConst(stringBuilder.toString(),i));

                            break;
                        case ' ':
                            state=State.A70;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A68:
                    switch (c){
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A69;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A69:
                    switch (c){
                        case'0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A69;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ']':
                            state=State.A71;
                            consts.add(new CaserConst(stringBuilder.toString(),i));

                            break;
                        case ' ':
                            state=State.A70;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A70:
                    switch (c){
                        case ' ':
                            state=State.A70;break;
                        case '}':
                            state=State.A71;                            break;
                        default:eMessage="ошибка в var на позиции "+i;return "e"+eMessage;
                    }break;
                case A71:
                    switch (c){
                        case ' ':
                            state=State.A71;break;
                        case ':':
                            state=State.A73;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="недопустимый символ после var на позиции "+i;return "e"+eMessage;
                    }break;
//                case A72:
//                    switch (c){
//                        case ' ':
//                            state=State.A72;break;
//                        case ':':
//                            state=State.A73;break;
//                        default:eMessage="mistake in stmt";return "e"+eMessage;
//                    }break;
                case A73:
                    switch (c){
                        case '=':
                            state=State.A74;break;
                        default:eMessage="ожидалось = на позиции "+i;return "e"+eMessage;
                    }break;
                case A74:
                    switch (c){
                        case ' ':
                            state=State.A74;break;
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                            state=State.A84;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '-':
                            state=State.A85;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '0':
                            state=State.A86;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A75;
                            stringBuilder=new StringBuilder();
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A75:
                    switch (c){
                        case'_':case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A66;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '+': case '-': case '*': case '/':
                            state=State.A74;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case ' ':
                            state=State.A76;break;
                        case '[':
                            state=State.A77;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A76:
                    switch (c){
                        case 'd':
                            state=State.A93;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case 'm':
                            state=State.A94;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case '[':
                            state=State.A74;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A76;break;
                        case '+': case '-': case '*': case '/':
                            state=State.A74;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case 'e':
                            state=State.A98;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A77:
                    switch (c){
                        case ' ':
                            state=State.A77;break;
                        case'_':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A78;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '0':
                            state=State.A81;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '-':
                            state=State.A80;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A79;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A78:
                    switch (c){
                        case'_':case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':case 'y':case 'z':
                            state=State.A78;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ']':
                            state=State.A83;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A82;break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A79:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A79;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ']':
                            state=State.A83;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A82;break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A80:
                    switch (c){
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A79;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A81:
                    switch (c){
                        case ']':
                            state=State.A83;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A82;break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A82:
                    switch (c){
                        case ']':
                            state=State.A83;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A83:
                    switch (c){
                        case ' ':
                            state=State.A92;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        case '+': case '-': case '*': case '/':
                            state=State.A74;
                            ids.add(new CaserId(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A84:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A84;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case 'e':
                            state=State.A89;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '.':
                            state=State.A87;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A92;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case '+': case '-': case '*': case '/':
                            state=State.A74;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A85:
                    switch (c){
                        case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A84;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '0':
                            state=State.A86;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A86:
                    switch (c){
                        case ' ':
                            state=State.A92;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case '.':
                            state=State.A88;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '+': case '-': case '*': case '/':
                            state=State.A74;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A87:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A88;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A88:
                    switch (c){
                        case 'e':
                            state=State.A89;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A92;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case '+': case '-': case '*': case '/':
                            state=State.A74;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A88;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A89:
                    switch (c){
                        case '-':
                            state=State.A91;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A90;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A90:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A90;
                            stringBuilder.append(string.charAt(i));
                            break;
                        case ' ':
                            state=State.A92;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A91:
                    switch (c){
                        case '0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8': case'9':
                            state=State.A90;
                            stringBuilder.append(string.charAt(i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A92:
                    switch (c){
                        case ' ':
                            state=State.A92;break;
                        case 'd':
                            state=State.A93;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case 'm':
                            state=State.A94;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case '+': case '-': case '*': case '/':
                            state=State.A74;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        case 'e':
                            state=State.A98;
                            consts.add(new CaserConst(stringBuilder.toString(),i));
                            break;
                        default:eMessage="ошибка в терме на позиции "+i;return "e"+eMessage;
                    }break;
                case A93:
                    switch (c){
                        case 'i':
                            state=State.A95;break;
                        default:eMessage="mistake in div на позиции "+i;return "e"+eMessage;
                    }break;
                case A94:
                    switch (c){
                        case 'o':
                            state=State.A96;break;
                        default:eMessage="mistake in mod на позиции "+i;return "e"+eMessage;
                    }break;
                case A95:
                    switch (c){
                        case 'v':
                            state=State.A97;break;
                        default:eMessage="mistake in div на позиции "+i;return "e"+eMessage;
                    }break;
                case A96:
                    switch (c){
                        case 'd':
                            state=State.A97;break;
                        default:eMessage="mistake in mod на позиции "+i;return "e"+eMessage;
                    }break;
                case A97:
                    switch (c){
                        case ' ':
                            state=State.A74;break;
                        default:eMessage="need space after keyword";return eMessage;
                    }break;
                case A98:
                    switch (c){
                        case 'n':
                            state=State.A99;break;
                        default:eMessage=" ошибка в ключевом слове на позиции "+i;return "e"+eMessage;
                    }break;
                case A99:
                    switch (c){
                        case 'd':
                            state=State.A100;break;
                        default:eMessage=" ошибка в ключевом слове на позиции "+i;return "e"+eMessage;
                    }break;
                case A100:
                    switch (c){
                        case ' ':
                            state=State.A100;break;
                        case ';':
                            state=State.F;break;
                        default:eMessage="erroe in keyword";return eMessage;
                    }break;
                default:eMessage="smth strange";return "e"+eMessage;
            }//CASE prim OF 14.3 : A[-1] := _A_L ELSE C := 8.3E - 3 END;


        }
        StringBuilder stringBuilder1=new StringBuilder();
        String result="";
        if(state==State.F){
            boolean error=false;
            for(int i=0;i<ids.size();i++){
                if(ids.get(i).er){
                    error=true;
                }
            }
            for(int i=0;i<consts.size();i++){
                if(consts.get(i).type==3){
                    error=true;
                }
            }
            if(error){
                stringBuilder1.append("цепочка не принадлежит языку");
            }else {
                stringBuilder1.append("цепочка принадлежит языку");
            }

            stringBuilder1.append("<br>Список идентификаторов: ");
            for(int i=0;i<ids.size();i++){
                for (int j=i+1;j<ids.size();j++){
                    if(ids.get(i).equals(ids.get(j)) ){
                        ids.remove(j);j--;
                    }
                }
            }
            for(int i=0;i<consts.size();i++){
                for (int j=i+1;j<consts.size();j++){
                    if(consts.get(i).equals(consts.get(j))){
                        consts.remove(j);j--;
                    }
                }
            }
            for(int i=0;i<ids.size();i++){
               // stringBuilder1.append("<br>");
                if(i!=0){
                    stringBuilder1.append(", ");
                }
                stringBuilder1.append(ids.get(i).id);
//                stringBuilder1.append(", ");
            }
            stringBuilder1.append("<br>Список констант: ");
            for(int i=0;i<consts.size();i++){
                //stringBuilder1.append("<br>");
                if(i!=0){
                stringBuilder1.append(", ");
                }
                stringBuilder1.append(consts.get(i).string);

            }
        }else {
            stringBuilder1.append("цепочка не принадлежит языку");
        }
        return stringBuilder1.toString();
    }
}
