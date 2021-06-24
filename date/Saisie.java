package date;
import java.util.Scanner;

public class Saisie
{ 
    public void saisie_date()
    {
        int[] liste_mois_31 = {3, 5, 7, 8, 10};
        int[] liste_mois_30 = {4, 6, 9, 11};

        Scanner donnee  = new Scanner(System.in);

        System.out.print("\n Entrer le jour : ");
        int jour_courant = donnee.nextInt();

        while(jour_courant > 31)
        {
            System.out.print("\n Coucou ! la date que vous êtes entrain de saisir n'est pas correcte \n ");
            System.out.print("\n Entrer un jour compris entre [1, 31] ou Ctrl + c pour quitter le programme : ");
            jour_courant = donnee.nextInt();
        }
        
        System.out.print("\n Entrer le mois : ");
        int mois_courant = donnee.nextInt();
        
        while(mois_courant > 12 || mois_courant < 1)
        {
            System.out.print("\n Coucou ! la date que vous êtes entrain de saisir n'est pas correcte \n ");
            System.out.print("\n Entrer un mois compris entre [1, 12] ou Ctrl + c pour quitter le programme : ");
            mois_courant = donnee.nextInt();
        }

        System.out.print("\n Entrer l'année : ");
        int annee_courant = donnee.nextInt();

        Algo_date date = new Algo_date(jour_courant, mois_courant, annee_courant);

        if(mois_courant == 1)
        {
            date.mois_de_janvier();
            date.affichage();

        }else if(mois_courant == 2){
            
            if(jour_courant > 29)
            {
                System.out.println("\n ------------ + ------------- ");
                System.out.println("\n La date que vous avez saisie n'est pas correcte");
                System.out.println(" Le mois de Fevrier ne peux pas avoir " + jour_courant );
            }else{
                date.annee_bissextile();
                date.affichage();
            }

        }else if (mois_courant == 12){

            date.mois_de_decembre();
            date.affichage();

        }else{
            
            for(int i = 0; i < liste_mois_30.length; i++)
            {
                if(liste_mois_30[i] == mois_courant)
                {
                    if(jour_courant > 30)
                    {
                        System.out.println("\n ------------ + ------------- ");
                        System.out.println("\n La date que vous avez saisie n'est pas correcte");
                        System.out.println(" Le "+ liste_mois_30[i] + "ème mois ne peux pas avoir " + jour_courant );
                    }else{
                        date.mois_30();
                        date.affichage();
                    }
                }
                break;
            }

            for(int i = 0; i < liste_mois_31.length; i++)
            {
                if(liste_mois_31[i] == mois_courant)
                {
                    if(jour_courant > 31)
                    {
                        System.out.println("\n ------------ + ------------- ");
                        System.out.println("\n La date que vous avez saisie n'est pas correcte");
                        System.out.println(" Le "+ liste_mois_31[i] + "ème mois ne peux pas avoir " + jour_courant );
                    }else{
                        date.mois_31();
                        date.affichage();
                    }

                }
            }
        }

    }
}