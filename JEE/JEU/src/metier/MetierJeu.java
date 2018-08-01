package metier;

public class MetierJeu {
	private int nombreSecret;
	private boolean fin;
	
	
	public MetierJeu() {
		
	}
	public void genererSecret() {
		nombreSecret = (int) (Math.random()*1000);
	}
	public String Jouer(int nb) {
		if (fin == false) {
			if(nb > nombreSecret) {
				return "votre nombre"+nb+" est plus grand";
				} else if (nb < nombreSecret) {
					return "votre nombre"+nb+" est plus petit";
					} else {
						fin =true;
						this.Jouer(nb);
						return "Bravo, vous avez gagné";
						
					}
		}else {
			return "le jeu est terminé, le nombre recherché est: "+ nombreSecret;
		}
		
	}

}

