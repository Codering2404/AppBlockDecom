package com.squareup.okhttp.internal.framed;

import java.util.List;
import okio.BufferedSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public interface PushObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PushObserver f93296a = new PushObserver() { // from class: com.squareup.okhttp.internal.framed.PushObserver.1
        @Override // com.squareup.okhttp.internal.framed.PushObserver
        public boolean a(int i3, List list) {
            return true;
        }

        @Override // com.squareup.okhttp.internal.framed.PushObserver
        public boolean b(int i3, List list, boolean z2) {
            return true;
        }

        @Override // com.squareup.okhttp.internal.framed.PushObserver
        public boolean c(int i3, BufferedSource bufferedSource, int i4, boolean z2) {
            bufferedSource.skip(i4);
            return true;
        }

        @Override // com.squareup.okhttp.internal.framed.PushObserver
        public void d(int i3, ErrorCode errorCode) {
        }
    };

    boolean a(int i3, List list);

    boolean b(int i3, List list, boolean z2);

    boolean c(int i3, BufferedSource bufferedSource, int i4, boolean z2);

    void d(int i3, ErrorCode errorCode);
}
