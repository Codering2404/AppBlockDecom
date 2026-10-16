package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum MessageDialogFeature implements DialogFeature {
    MESSAGE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140204),
    PHOTOS(NativeProtocol.PROTOCOL_VERSION_20140324),
    VIDEO(NativeProtocol.PROTOCOL_VERSION_20141218),
    MESSENGER_GENERIC_TEMPLATE(NativeProtocol.PROTOCOL_VERSION_20171115),
    MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE(NativeProtocol.PROTOCOL_VERSION_20171115),
    MESSENGER_MEDIA_TEMPLATE(NativeProtocol.PROTOCOL_VERSION_20171115);

    private int minVersion;

    MessageDialogFeature(int i3) {
        this.minVersion = i3;
    }

    @Override // com.facebook.internal.DialogFeature
    public String getAction() {
        return NativeProtocol.ACTION_MESSAGE_DIALOG;
    }

    @Override // com.facebook.internal.DialogFeature
    public int getMinVersion() {
        return this.minVersion;
    }
}
