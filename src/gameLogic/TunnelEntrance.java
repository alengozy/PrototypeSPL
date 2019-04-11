package gameLogic;

import java.util.*;

/**
 * This class is responsible for the entrances of the tunnels. When the train
 * disappears at one end, it emerges at the other end which is implemented by
 * this class.
 */
class TunnelEntrance extends Segment {

	/**
	 * Default constructor
	 */
	public TunnelEntrance(String id) {
		super(id);
	}

	/**
	 * This attribute stores the tunnel which corresponds to the given entrance.
	 */
	protected Tunnel tunnel;

	/**
	 * This method sets the entrance of the tunnel to null.
	 */
	public void Clear() {
		System.out.println(">>Clear(): Sets the tunnel for te2 to null.");
		tunnel = null;
	}

	/**
	 * This method sets the tunnel of both entrances to null.
	 */
	public void FullClear() {
		System.out.println(
				">>FullClear(): Clears the tunnels for both entrances if the tunnel was set previously. This is checked two times. For the entrance te1 and for the entrance te2.");
		if (tunnel != null)
			tunnel.GetTheOtherEnd(this).Clear();
		Clear();
	}

	/**
	 * This method sets the tunnel for the current Tunnel Entrance.
	 */
	public void SetTunnel(Tunnel newTunnel) {
		System.out.println(">>SetTunnel(Tunnel newTunnel): Sets the new tunnel for one of the entrances.");
		this.tunnel = newTunnel;
	}

	/**
	 * This method selects the current entrance.
	 */

	public void Select() {
		System.out.println(">>Select(TunnelEntrance te): Selects the entrance referenced by the FindSegment() method.");
		if (LevelContainer.IsEntranceSelected()) {
			if (LevelContainer.IsTunnelPossibleFrom(this)) {
				LevelContainer.ConstructFrom(this);
			}
			if (LevelContainer.IsThisSelected(this)) {
				LevelContainer.SelectEntrance(null);
			}

		} else {
			LevelContainer.SelectEntrance(this);
		}

	}
}