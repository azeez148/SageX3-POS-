package com.adonix.wsvc;

import com.adonix.awss.stubs.CAdxParamKeyValue;

/**
 * @author Adonix Grenoble
 * @version 14w
 * 
 */
public class CServiceAdxKeys
{
	private CAdxParamKeyValue[] pCAdxObjKeyValues;

	private int pSize;

	/**
	 * @param aSize
	 */
	public CServiceAdxKeys(int aSize)
	{
		pSize = aSize;
		pCAdxObjKeyValues = new CAdxParamKeyValue[aSize];
	}

	/**
	 * @return
	 */
	public CAdxParamKeyValue[] getAdxParamsKeys()
	{
		return pCAdxObjKeyValues;
	}

	/**
	 * @param aIdx
	 * @param aKey
	 * @param aValue
	 */
	public void set(int aIdx, String aKey, String aValue)
	{
		CAdxParamKeyValue wAdxParamKeyValue = new CAdxParamKeyValue();
		wAdxParamKeyValue.setKey(aKey);
		wAdxParamKeyValue.setValue(aValue);

		pCAdxObjKeyValues[aIdx] = wAdxParamKeyValue;
	}
}
