package com.facebook.share.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.common.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context) {
        super(context, null, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    @Override // com.facebook.share.widget.ShareButtonBase, com.facebook.FacebookButtonBase
    protected void configureButton(Context context, AttributeSet attributeSet, int i3, int i4) {
        super.configureButton(context, attributeSet, i3, i4);
        setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.b(getContext(), R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultStyleResource() {
        return com.facebook.share.R.style.com_facebook_button_share;
    }

    @Override // com.facebook.share.widget.ShareButtonBase
    protected ShareDialog getDialog() {
        ShareDialog shareDialog = getFragment() != null ? new ShareDialog(getFragment(), getRequestCode()) : getNativeFragment() != null ? new ShareDialog(getNativeFragment(), getRequestCode()) : new ShareDialog(getActivity(), getRequestCode());
        shareDialog.setCallbackManager(getCallbackManager());
        return shareDialog;
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }
}
