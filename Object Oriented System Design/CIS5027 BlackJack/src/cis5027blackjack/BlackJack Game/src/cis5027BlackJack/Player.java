/**
 * Implementation of the Player Class
 * 
 * @author St20155999
 * 
 */
package cis5027BlackJack;

public class Player {
	
	public class AddPlayer {
		private String name;
		private int winCount;
		private int drawCount;
		private int loseCount;
		private int boardPosition;
		
		public void Player(String name, int position){		
			this.setName(name);
			this.setBoardPosition(position);
					this.winCount = 0;
			this.loseCount = 0;
			}
			
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getWinCount() {
			return winCount;
		}

		public void addWin() {
			this.winCount++;
		}

		public int getLostCount() {
			return loseCount;
		}

		public void addLose() {
			this.loseCount++;
		}
		
		public int getDrawCount() {
			return drawCount;
		}

		public void addDraw() {
			this.drawCount++;
		}

		public void resetStats(){
			this.winCount = 0;
			this.loseCount = 0;
		}

		public int getBoardPosition() {
			return boardPosition;
		}

		public void setBoardPosition(int boardPosition) {
			this.boardPosition = boardPosition;
		}


	}

	public Player(String pName, int i) {
		// Constructor for Player
	}

	public static void add(Player newPlayer) {
		// Add New Player
	}

}
