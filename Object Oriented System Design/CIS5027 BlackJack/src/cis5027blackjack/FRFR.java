package cis5027blackjack;

public class AddPlayerMessage 
implements Serializable 
{
	public static final long serialVersionUID = 1;
	private String playerName;
	private String gameName;
	
	public AddPlayerMessage(String playerName, String gameName)
	{
		this.playerName = playerName;
		this.gameName = gameName;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public String getGameName() {
		return gameName;
	}
}