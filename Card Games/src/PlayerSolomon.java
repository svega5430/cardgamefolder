

public class PlayerSolomon extends Player {
	public PlayerSolomon(String temp){
		super(temp);
	}
	 public Card play(Eights eights, Card prev) {
	        Card card = searchForBestMatch(prev);
	        if (card == null) {
	            card = drawForMatch(eights, prev);
	        }
	        return card;
	    }



}