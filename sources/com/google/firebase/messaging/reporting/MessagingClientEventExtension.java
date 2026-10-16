package com.google.firebase.messaging.reporting;

import com.google.firebase.messaging.ProtoEncoderDoNotUse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MessagingClientEventExtension {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MessagingClientEventExtension f89596b = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessagingClientEvent f89597a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MessagingClientEvent f89598a = null;

        Builder() {
        }

        public MessagingClientEventExtension a() {
            return new MessagingClientEventExtension(this.f89598a);
        }

        public Builder b(MessagingClientEvent messagingClientEvent) {
            this.f89598a = messagingClientEvent;
            return this;
        }
    }

    MessagingClientEventExtension(MessagingClientEvent messagingClientEvent) {
        this.f89597a = messagingClientEvent;
    }

    public static Builder b() {
        return new Builder();
    }

    public MessagingClientEvent a() {
        return this.f89597a;
    }

    public byte[] c() {
        return ProtoEncoderDoNotUse.a(this);
    }
}
