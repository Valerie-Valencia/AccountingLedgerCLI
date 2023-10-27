package org.example;

public class ReportScreen {

    public static void main(String[] args)
    {
        showReportScreen();
    }

    public static void showReportScreen()
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
                \t ;;       ;;;;;                    R E P O R T  M E N U                  ;;;;;     ;;
                \t ;;       ;;;;;                                                          ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;      [1]  ;;          MONTH TO DATE           ;;         ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;                                                          ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;      [2]  ;;          PREVIOUS MONTH          ;;         ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;                                                          ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;      [3]  ;;           YEAR TO DATE           ;;         ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;                                                          ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;      [4]  ;;           PREVIOUS YEAR          ;;         ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;                                                          ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;      [5]  ;;         SEARCH BY VENDOR         ;;         ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;                                                          ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;      [0]  ;;               BACK               ;;         ;;;;;     ;;
                \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                \t ;;       ;;;;;                                                          ;;;;;     ;;
                \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                \t ;;                                                                                ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                """
        );
        Report.reportChoice();
    }
}