package faber.tool.configuration.objet;

public class ConfigurationApplication {
    private static String cheminDossierMaj;
    private static String version;
    private static String informationMiseAJour;
    private static String couleurColonnePaire;
    private static String couleurColonneImpaire;


    public ConfigurationApplication() {

    }

    public static String getCheminDossierMaj() {
        return cheminDossierMaj;
    }

    public static void setCheminDossierMaj(String cheminDossierMaj) {
        ConfigurationApplication.cheminDossierMaj = cheminDossierMaj;
    }

    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        ConfigurationApplication.version = version;
    }

    public static String getInformationMiseAJour() {
        return informationMiseAJour;
    }

    public static void setInformationMiseAJour(String informationMiseAJour) {
        ConfigurationApplication.informationMiseAJour = informationMiseAJour;
    }

    public static String getCouleurColonnePaire() {
        return couleurColonnePaire;
    }

    public static void setCouleurColonnePaire(String couleurColonnePaire) {
        ConfigurationApplication.couleurColonnePaire = couleurColonnePaire;
    }

    public static String getCouleurColonneImpaire() {
        return couleurColonneImpaire;
    }

    public static void setCouleurColonneImpaire(String couleurColonneImpaire) {
        ConfigurationApplication.couleurColonneImpaire = couleurColonneImpaire;
    }
}
