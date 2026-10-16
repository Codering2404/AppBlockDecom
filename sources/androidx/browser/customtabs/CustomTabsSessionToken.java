package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class CustomTabsSessionToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ICustomTabsCallback f2662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PendingIntent f2663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CustomTabsCallback f2664c;

    CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f2662a = iCustomTabsCallback;
        this.f2663b = pendingIntent;
        this.f2664c = iCustomTabsCallback == null ? null : new CustomTabsCallback() { // from class: androidx.browser.customtabs.CustomTabsSessionToken.1
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void extraCallback(String str, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.u1(str, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public Bundle extraCallbackWithResult(String str, Bundle bundle) {
                try {
                    return CustomTabsSessionToken.this.f2662a.w0(str, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                    return null;
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onActivityLayout(int i3, int i4, int i5, int i6, int i7, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.d0(i3, i4, i5, i6, i7, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onActivityResized(int i3, int i4, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.P3(i3, i4, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onMessageChannelReady(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.W4(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onMinimized(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.s3(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onNavigationEvent(int i3, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.t4(i3, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onPostMessage(String str, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.P4(str, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onRelationshipValidationResult(int i3, Uri uri, boolean z2, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.Z4(i3, uri, z2, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onUnminimized(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.D3(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onWarmupCompleted(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f2662a.E1(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }
        };
    }

    private IBinder b() {
        ICustomTabsCallback iCustomTabsCallback = this.f2662a;
        if (iCustomTabsCallback != null) {
            return iCustomTabsCallback.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    IBinder a() {
        ICustomTabsCallback iCustomTabsCallback = this.f2662a;
        if (iCustomTabsCallback == null) {
            return null;
        }
        return iCustomTabsCallback.asBinder();
    }

    PendingIntent c() {
        return this.f2663b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
        PendingIntent pendingIntentC = customTabsSessionToken.c();
        PendingIntent pendingIntent = this.f2663b;
        if ((pendingIntent == null) != (pendingIntentC == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(pendingIntentC) : b().equals(customTabsSessionToken.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.f2663b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MockCallback extends ICustomTabsCallback.Stub {
        @Override // android.support.customtabs.ICustomTabsCallback
        public Bundle w0(String str, Bundle bundle) {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsCallback.Stub, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void D3(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void E1(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void W4(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void s3(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void P4(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void t4(int i3, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void u1(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void P3(int i3, int i4, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void Z4(int i3, Uri uri, boolean z2, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void d0(int i3, int i4, int i5, int i6, int i7, Bundle bundle) {
        }
    }
}
