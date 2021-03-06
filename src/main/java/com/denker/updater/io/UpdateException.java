//--------------------------------------
//  Kyle Russell
//  Auto-Updater
//  github.com/denkers/auto-updater
//--------------------------------------

package com.denker.updater.io;

public class UpdateException extends Exception 
{
    public static enum ErrorCode
    {
        CLIENT_CONN_FAIL,
        CLIENT_DISC_FAIL,
        SVERSION_CHECK_FAIL,
        CVERSION_CHECK_FAIL,
        PATCH_DL_ERR,
        UNPACK_PATCH_ERR,
        REMOVE_PATCH_ERR,
    }
    
    private final ErrorCode errorCode;
    private final Exception ex;
    
    public UpdateException(ErrorCode errorCode, Exception ex)
    {
        this.errorCode  =   errorCode;
        this.ex         =   ex;
    }
    
    @Override
    public String getMessage()
    {
        switch(errorCode)
        {
            case CLIENT_CONN_FAIL: return "Failed to connect to FTP server";
            case CLIENT_DISC_FAIL: return "Failed to disconnect from FTP server";
            case SVERSION_CHECK_FAIL: return "Failed to check server application version";
            case CVERSION_CHECK_FAIL: return "Failed to check client application version";
            case PATCH_DL_ERR: return "Error occured downloading patch";
            case UNPACK_PATCH_ERR: return "Failed to unpack patch contents";
            case REMOVE_PATCH_ERR: return "Failed to remove patch package";
            default: return "Error code not found";
        }
    }
    
    @Override
    public void printStackTrace()
    {
        if(ex != null)
            ex.printStackTrace();
    }

    public ErrorCode getErrorCode()
    {
        return errorCode;
    }
}
