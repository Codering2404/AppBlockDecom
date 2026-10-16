package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ShareButtonBase extends FacebookButtonBase {
    private CallbackManager callbackManager;
    private boolean enabledExplicitlySet;
    private int requestCode;
    private ShareContent shareContent;

    protected ShareButtonBase(Context context, AttributeSet attributeSet, int i3, String str, String str2) {
        super(context, attributeSet, i3, 0, str, str2);
        this.requestCode = 0;
        this.enabledExplicitlySet = false;
        this.requestCode = isInEditMode() ? 0 : getDefaultRequestCode();
        internalSetEnabled(false);
    }

    private void internalSetEnabled(boolean z2) {
        setEnabled(z2);
        this.enabledExplicitlySet = false;
    }

    private void memorizeCallbackManager(CallbackManager callbackManager) {
        CallbackManager callbackManager2 = this.callbackManager;
        if (callbackManager2 == null) {
            this.callbackManager = callbackManager;
        } else if (callbackManager2 != callbackManager) {
            Log.w(ShareButtonBase.class.toString(), "You're registering a callback on a Facebook Share Button with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    protected boolean canShare() {
        return getDialog().canShow(getShareContent());
    }

    @Override // com.facebook.FacebookButtonBase
    protected void configureButton(Context context, AttributeSet attributeSet, int i3, int i4) {
        super.configureButton(context, attributeSet, i3, i4);
        setInternalOnClickListener(getShareOnClickListener());
    }

    protected CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    protected abstract ShareDialog getDialog();

    @Override // com.facebook.FacebookButtonBase
    public int getRequestCode() {
        return this.requestCode;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    protected View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() { // from class: com.facebook.share.widget.ShareButtonBase.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    ShareButtonBase.this.callExternalOnClickListener(view);
                    ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        };
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback) {
        memorizeCallbackManager(callbackManager);
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, facebookCallback);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.enabledExplicitlySet = true;
    }

    protected void setRequestCode(int i3) {
        if (!FacebookSdk.isFacebookRequestCode(i3)) {
            this.requestCode = i3;
            return;
        }
        throw new IllegalArgumentException("Request code " + i3 + " cannot be within the range reserved by the Facebook SDK.");
    }

    public void setShareContent(ShareContent shareContent) {
        this.shareContent = shareContent;
        if (this.enabledExplicitlySet) {
            return;
        }
        internalSetEnabled(canShare());
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback, int i3) {
        setRequestCode(i3);
        registerCallback(callbackManager, facebookCallback);
    }
}
