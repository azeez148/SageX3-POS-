package com.adonix.wsvc;

import com.adonix.wsvc.stubs.CAdxResultXml;

public class CServiceAdxResult extends CAdxResultXml
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -969561754974218450L;

	/**
	 * @param aSB
	 * @param aId
	 * @param aValue
	 * @return
	 */
	private static StringBuffer addDescrInSB(StringBuffer aSB, String aId, String aValue)
	{
		if (aSB.length() > 0 && aSB.toString().lastIndexOf('\n') != aSB.length() - 1)
		{
			aSB.append(' ');
		}
		aSB.append(aId);
		aSB.append("=[");
		aSB.append(aValue);
		aSB.append(']');

		return aSB;
	}

	/**
	 * @param aSB
	 * @param aId
	 * @param aValue
	 * @param aValueB
	 * @return
	 */
	private static StringBuffer addDescrInSB(StringBuffer aSB, String aId, String aValue, String aValueB)
	{
		return addDescrInSB(aSB, aId, aValue + " | " + aValueB);
	}

	/**
	 * @param aAdxResultXml
	 */
	public CServiceAdxResult(CAdxResultXml aAdxResultXml)
	{
		setMessages(aAdxResultXml.getMessages());
		setResultXml(aAdxResultXml.getResultXml());
		setStatus(aAdxResultXml.getStatus());
		setTechnicalInfos(aAdxResultXml.getTechnicalInfos());
	}

	/**
	 * @return
	 */
	public String dump()
	{
		StringBuffer wSB = new StringBuffer();

		addDescrInSB(wSB, "Status", String.valueOf(getStatus()));
		boolean wHasStatus = (getStatus() > -1);
		wSB.append('\n');
		addDescrInSB(wSB, "HasValidStatus", String.valueOf(getStatus()));

		if (wHasStatus)
		{
			int wNbMess = getMessages().length;
			wSB.append('\n');
			addDescrInSB(wSB, "nbMess", String.valueOf(wNbMess));

			int wI = 0;
			while (wI < wNbMess)
			{
				wSB.append('\n');
				addDescrInSB(wSB, String.valueOf(wI), getMessages()[wI].getType(), getMessages()[wI].getMessage());
				wI++;
			}

			String wResultXml = getResultXml();
			boolean wHasResultXml = (wResultXml != null);
			addDescrInSB(wSB, "HasResultXml", String.valueOf(wHasResultXml));
			if (wHasResultXml)
			{
				wSB.append('\n');
				addDescrInSB(wSB, "ResultXml", '\n' + wResultXml + '\n');
			}
		}

		return wSB.toString();
	}
}
