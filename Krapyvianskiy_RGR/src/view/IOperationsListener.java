package view;

import java.util.EventListener;

public interface IOperationsListener extends EventListener{
	public void onOperationsEvent(OperEvent e);
}
