package date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Algo_date
{
    protected int jour_courant;
    protected int mois_courant;
    protected int annee_courant;

    private int jour_suivant;
    private int mois_suivant;
    private int annee_suivant;

    private int jour_precedent;
    private int mois_precedent;
    private int annee_precedente;
    
    public Algo_date(int jour, int mois, int annee)
    {
        this.jour_courant = jour;
        this.mois_courant = mois;
        this.annee_courant = annee;

        this.jour_precedent = jour - 1;
        this.mois_precedent = mois;
        this.annee_precedente = annee;

        this.jour_suivant = jour + 1;
        this.mois_suivant = mois;
        this.annee_suivant = annee;
    }

    public void affiche_jour()
    {
        SimpleDateFormat formater = new SimpleDateFormat("EEEE, d MMM yyyy");
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = this.jour_courant + "/" + this.mois_courant + "/" + this.annee_courant;

        try {
            date = simpleDateFormat.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("\n " + formater.format(date));
    }

    public void mois_31()
    {
        switch(this.jour_courant)
        {
            case 1:
                if(this.mois_courant == 8)
                {
                    this.jour_precedent = 31;
                    this.mois_precedent = this.mois_courant - 1;
                    break;
                }else if(this.mois_courant == 3){
                    if(is_bissextile(this.annee_courant) == true)
                    {
                        this.jour_precedent = 29;
                        this.mois_precedent = this.mois_courant - 1;
                    }else{
                        this.jour_precedent = 28;
                        this.mois_precedent = this.mois_courant - 1;
                    }
                }else{
                    this.jour_precedent = 30;
                    break;
                }
            case 31:
                this.jour_suivant = 1;
                this.mois_suivant = this.mois_courant + 1;
                break;
        }
    }

    public void mois_30()
    {
        switch(this.jour_courant)
        {
            case 1:
                this.jour_precedent = 31;
                this.mois_precedent = this.mois_courant - 1;
                break;
            case 30:
                this.jour_suivant = 1;
                this.mois_suivant = this.mois_courant + 1;
                break;
        }
    }

    /**
        Cas de 1 Janvier 
        Dans ce cas, on ajoute une journée pour avoir la date suivant 
        pour la date précédente : 
        jour_precedent = 31
        mois_precedent = 12
        annee_precente = annee_courante - 1
     */
    public void mois_de_janvier()
    {
        if(this.mois_courant == 1 && this.jour_courant == 1)
        {
            this.jour_precedent = 31;
            this.mois_precedent = 12;
            this.annee_precedente = this.annee_courant - 1;

            this.jour_suivant = this.jour_courant + 1;

        }else if( this.jour_courant == 31 && this.mois_courant == 1){

            this.jour_precedent = 30;
            this.jour_suivant = 1;
            this.mois_suivant = 2;

        }else{
            this.generalite();
        }
    }

    public void mois_de_decembre()
    {
        if(this.jour_courant == 1 && this.mois_courant == 12 )
        {
            this.jour_precedent = 30;
            this.mois_precedent = this.mois_courant - 1;
            this.annee_precedente = this.annee_courant - 1;
            this.jour_suivant = this.jour_courant + 1;

        }else if( this.jour_courant == 31 && this.mois_courant == 12){
            
            this.jour_precedent = 30;

            this.jour_suivant = 1;
            this.mois_suivant = 1;
            this.annee_suivant = this.annee_courant + 1;

        }else{
            this.generalite();
        }
    }
    
    /**
        Cas général, 
        dans ce cas, on ajoute une journée pour avoir la date suivant 
        on soustrait une journée pour avoir la date précédente
     */
    private void generalite()
    {
        this.jour_suivant = this.jour_courant + 1;
        this.mois_suivant = this.mois_courant;
        this.annee_suivant = this.annee_courant;

        this.jour_precedent = this.jour_courant - 1;
        this.mois_precedent = this.mois_courant;
        this.annee_precedente = this.annee_courant;
    }

    /**
        Foonction qui vérifie si l'année est bissextile
     */
    private boolean is_bissextile(int annee)
    {
        boolean est_bissextile = false;
        if(annee % 4 == 0)
        {
            est_bissextile = true;
        }
        return est_bissextile;
    }

    public void annee_bissextile()
    {
        switch(this.jour_courant)
        {
            case 1:
                this.jour_precedent = 31;
                this.mois_precedent = 1;
                break;
            case 28:
                if(is_bissextile(this.annee_courant) == false)
                {
                    this.jour_suivant = 1;
                    this.mois_suivant = 3;
                    break;
                }
            case 29:
                if(is_bissextile(this.annee_courant) == true)
                {
                    this.jour_suivant = 1;
                    this.mois_suivant = 3;
                    break;
                }
        }
        
    }

    public void affichage()
    {
        System.out.println("\n \t \t ---------------- + -------------");
        System.out.println("\n La date précedente : le " + this.jour_precedent + "/" + this.mois_precedent + "/" + this.annee_precedente); 
        System.out.println("\n La date saisie : le " + this.jour_courant + "/" + this.mois_courant + "/" + this.annee_courant); 
        System.out.println("\n La date suivante : le " + this.jour_suivant + "/" + this.mois_suivant + "/" + this.annee_suivant);
        
        System.out.println("\n \t \t ---------------- + -------------");

        this.affiche_jour(); 

    }

}