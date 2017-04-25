package com.adonix.wsvc;

import com.adonix.awss.stubs.CAdxResultXml;
import com.adonix.awss.stubs.CAdxSubProgramXml;
import com.adonix.awss.stubs.CAdxSubProgramXmlServiceLocator;
import org.apache.axis.client.Stub;

/**
 * @author Adonix Grenoble
 * 
 */
public class CServiceAdxSubProgram extends CServiceAdx
{
	public static String URL_SUBPATH = "/services/CAdxSubProgramXml";

	CAdxSubProgramXml pService;

	CAdxSubProgramXmlServiceLocator pServiceLocator;

	/**
	 * @param aActivityViewer
	 * @param aObjId
	 * @param aUrl
	 * @param aCtx
	 * @throws Exception
	 */
	public CServiceAdxSubProgram(CActivityViewer aActivityViewer, String aSpgmId, String aUrl, CServiceAdxCallContext aCtx)
			throws Exception
	{
		super(aActivityViewer, aSpgmId, aUrl, aCtx);

		pServiceLocator = new CAdxSubProgramXmlServiceLocator();

		pServiceLocator.setCAdxSubProgramXmlEndpointAddress(aUrl);
		
		pService = pServiceLocator.getCAdxSubProgramXml();
		
		setHeaderElement((Stub)pService);

		if (pActivityViewerOn)
			pActivityViewer.traceWrite("new CServiceAdxSubProgram ok");
	}

	/**
	 * @param aDataXml
	 * @return
	 * @throws Exception
	 */
	public CServiceAdxResult execRun(String aDataXml) throws Exception
	{
		if (pActivityViewerOn)
			pActivityViewer.traceBeginStep("execSpgm");

		CAdxResultXml wAdxResultXml = pService.runXml(getWsSpgmId(), aDataXml);

		if (pActivityViewerOn)
			pActivityViewer.traceEndStep();
		return new CServiceAdxResult(wAdxResultXml);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public CServiceAdxResult execGetDescription() throws Exception
	{
		if (pActivityViewerOn)
			pActivityViewer.traceBeginStep("getDescription");

		CAdxResultXml wAdxResultXml = pService.getDescription(getWsSpgmId());

		if (pActivityViewerOn)
			pActivityViewer.traceEndStep();
		return new CServiceAdxResult(wAdxResultXml);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer wSB = new StringBuffer();
		wSB.append("WsSpgmId=[").append(getWsSpgmId()).append(']');
		wSB.append('\n');
		wSB.append(super.toString());
		return wSB.toString();
	}
}
