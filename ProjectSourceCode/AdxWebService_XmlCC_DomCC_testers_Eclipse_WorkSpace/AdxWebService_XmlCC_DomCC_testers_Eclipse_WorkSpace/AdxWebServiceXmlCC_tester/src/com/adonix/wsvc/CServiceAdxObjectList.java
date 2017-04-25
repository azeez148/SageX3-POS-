package com.adonix.wsvc;

import com.adonix.wsvc.stubs.CAdxResultXml;

/**
 * @author Adonix Grenoble
 *
 */
public class CServiceAdxObjectList extends CServiceAdx
{
	/**
	 * @param aActivityViewer
	 * @param aObjId
	 * @param aUrl
	 * @param aCtx
	 * @throws Exception
	 */
	public CServiceAdxObjectList(CActivityViewer aActivityViewer, String aObjId, String aUrl, CServiceAdxCallContext aCtx)
			throws Exception
	{
		super(aActivityViewer, aObjId, aUrl, aCtx);

		if (pActivityViewerOn)
			pActivityViewer.traceWrite("new CServiceAdxObjectList ok");
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public CServiceAdxResult execGetDescription() throws Exception
	{
		if (pActivityViewerOn)
			pActivityViewer.traceBeginStep("getDescription");

		CAdxResultXml wAdxResultXml = pService.getDescription(getAdxCallContext(), getWsObjId());

		if (pActivityViewerOn)
			pActivityViewer.traceEndStep();
		return new CServiceAdxResult(wAdxResultXml);
	}

	/**
	 * @param aListKeys
	 * @param aListSize
	 * @return
	 * @throws Exception
	 */
	public CServiceAdxResult execQuery(CServiceAdxKeys aListKeys, int aListSize) throws Exception
	{
		if (pActivityViewerOn)
			pActivityViewer.traceBeginStep("execQuery");

		CAdxResultXml wAdxResultXml = pService.query(getAdxCallContext(), getWsObjId(), aListKeys.getAdxParamsKeys(), aListSize);

		if (pActivityViewerOn)
			pActivityViewer.traceEndStep();
		return new CServiceAdxResult(wAdxResultXml);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer wSB = new StringBuffer();
		wSB.append("WsObjId=[").append(getWsObjId()).append(']');
		wSB.append('\n');
		wSB.append(super.toString());
		return wSB.toString();
	}
}
