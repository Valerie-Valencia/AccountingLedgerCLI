package org.example;

public class HomeScreen {

    public static void main(String[] args)
    {
        showHomeScreen();
    }

    public static void showHomeScreen()
    {
        System.out.println
        (
                """
                 \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                 \t ;;                                                                                ;;
                 \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                 \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                 \t ;;       ;;;;;                                                          ;;;;;     ;;
                 \t ;;       ;;;;;                      /////////////////|                  ;;;;;     ;;
                 \t ;;       ;;;;;                     ///////////////// |                  ;;;;;     ;;
                 \t ;;       ;;;;;                     ::::::::::::::::: |                  ;;;;;     ;;
                 \t ;;       ;;:::                     ::::::::::::::::: |                  ;;;;;     ;;
                 \t ;;       ;;;;;                     :::::::::::::::::/                   ;;;;;     ;;
                 \t ;;       ;;;;;                                                          ;;;;;     ;;
                 \t ;;       ;;;;;                      H O M E  M E N U                    ;;;;;     ;;
                 \t ;;       ;;;;;                                                          ;;;;;     ;;
                 \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                 \t ;;       ;;;;;      [D]  ;;            ADD DEPOSIT           ;;         ;;;;;     ;;
                 \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                 \t ;;       ;;;;;                                                          ;;;;;     ;;
                 \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                 \t ;;       ;;;;;      [P]  ;;           MAKE PAYMENT           ;;         ;;;;;     ;;
                 \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                 \t ;;       ;;;;;                                                          ;;;;;     ;;
                 \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                 \t ;;       ;;;;;      [L]  ;;              LEDGER              ;;         ;;;;;     ;;
                 \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                 \t ;;       ;;;;;                                                          ;;;;;     ;;
                 \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                 \t ;;       ;;;;;      [X]  ;;               EXIT               ;;         ;;;;;     ;;
                 \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                 \t ;;       ;;;;;                                                          ;;;;;     ;;
                 \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                 \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                 \t ;;                                                                                ;;
                 \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                 """
        );
        Home.homeChoice();
    }
}
