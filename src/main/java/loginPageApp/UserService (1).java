package loginPageApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    List<String>emails=new ArrayList<>();

    List<String>passwords=new ArrayList<>();

    //3- ad soyad,email,sifre alıp-> listeye kaydedelim
    public void register(){
        Scanner input=new Scanner(System.in);
        System.out.println("lutfen ad-soyad giriniz");
        String name=input.nextLine();

        //4 email gecersizse tekrar girmeli
        String email; //ahmetfurkankisacik@gmail.com 123
        boolean isValid;
        do {
            System.out.println("email adresinizi giriniz");
            email=input.nextLine();
            isValid=validateEmail(email);
            if (this.emails.contains(email)) {
                System.out.println("Bu email zaten kayitlı bir kullanici tarafindan kullanilmakta");
                isValid=false;
            }

        }while (!isValid);
        //5 password olusturalim
        String password;
        boolean isValidPassword;
        do {
            System.out.println("Şifrenizi olusturunuz : ");
            password=input.nextLine();
            isValidPassword=validatePassword(password);

        }while (!isValidPassword);
        //6 user olusturalım
        User user=new User(name,email,password);
        this.emails.add(user.email);
        this.passwords.add(user.password);
        System.out.println("Tebrikler, kayıt işlemi başaruıyla gerceklesti.");
        System.out.println("Email ve şifreniz ile sisteme giriş yapabilirsiniz.");


    }


    private boolean validatePassword(String password){
        //b
        boolean isValid;
        String lowerLetter=password.replaceAll("[^a-z]","");
        String upperLetter=password.replaceAll("[^A-Z]","");
        String rakam=password.replaceAll("[\\D]","");
        String symbol=password.replaceAll("[\\P{Punct}]","");

        boolean space=password.contains(" ");
        boolean lenght=password.length()>5;
        boolean existLowerLetter=lowerLetter.length()>0;
        boolean existUpperLetter=upperLetter.length()>0;
        boolean existRakam=rakam.length()>0;
        boolean existSymbol=symbol.length()>0;
        if (space){
            System.out.println("Şifre boşluk iceremez.");
        } else if (!lenght) {
            System.out.println("şifre en az 6 karakter icermelidir!");
        }else if (!existLowerLetter) {
            System.out.println("şifre en az 1 tane küçük harf icermelidir!");
        }else if (!existUpperLetter) {
            System.out.println("şifre en az 1 tane büyük harf icermelidir!");
        }else if (!existSymbol) {
            System.out.println("şifre en az 1 tane sembol icermelidir!");
        }else if (!existRakam) {
            System.out.println("şifre en az 1 tane rakam icermelidir!");
        }
        isValid=!space&&lenght&&existLowerLetter&&existUpperLetter&&existRakam&&existSymbol;
        if (!isValid){
            System.out.println("Geçersiz şifre, tekrar deneyiniz");
        }

      return isValid;
    }

    private boolean validateEmail(String email) {
        //a
        boolean isValid;
        boolean space=email.contains(" ");
        boolean containsAt=email.contains("@");//@
        if (space){
            System.out.println("Email boşluk içeremez");
        isValid=false;
        } else if (!containsAt) {
            System.out.println("email @ sembölünü icermeli");
            isValid=false;
        }else {//xyz!?*@@123
            String firstPart=email.split("@")[0];//xyz!?*
            String secondPart=email.split("@")[1];//@123
            //harf rakam ve -._ disinda karakter var mi?
            int notValidCharLenght=firstPart.replaceAll("[a-zA-Z0-9-._]","").length();
            boolean chechStart=notValidCharLenght==0;
            boolean checkEnd=secondPart.equals("gmail.com")||
                    secondPart.equals("hotmail.com")||
                    secondPart.equals("yahoo.com");
            if (!chechStart) {
                System.out.println("Email harf, rakam ve -._ dışında karakter iceremez");
            } else if (!checkEnd) {
                System.out.println("Email gmail.com, hotmail.com veya yahoo.com ile bitmelidir!");
            }
            isValid=checkEnd&&chechStart;

            if (!isValid){
                System.out.println("Geçersiz Email, tekrar deneyiniz");
            }


        }

       return isValid;
    }
}
