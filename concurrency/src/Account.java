class Account {
    private int solde = 1000;

    // Version non synchronisée (exprès)
    public boolean retraitUnsafe(int montant) {
        if (solde >= montant) {
            solde -= montant;
            return true;
        }
        return false;
    }

    public int getSolde() { return solde; }

    // Version sûre
    public synchronized boolean retraitSafe(int montant) {
        if (solde >= montant) {
            solde -= montant;
            return true;
        }
        return false;
    }
}