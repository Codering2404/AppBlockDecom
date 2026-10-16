package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.ud;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zn extends xa {
    public static final Parcelable.Creator<zn> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f65471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f65472c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zn[] newArray(int i3) {
            return new zn[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zn createFromParcel(Parcel parcel) {
            return new zn(parcel);
        }
    }

    zn(Parcel parcel) {
        super((String) xp.a((Object) parcel.readString()));
        this.f65471b = parcel.readString();
        this.f65472c = (String) xp.a((Object) parcel.readString());
    }

    private static List a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zn.class == obj.getClass()) {
            zn znVar = (zn) obj;
            if (xp.a((Object) this.f64884a, (Object) znVar.f64884a) && xp.a((Object) this.f65471b, (Object) znVar.f65471b) && xp.a((Object) this.f65472c, (Object) znVar.f65472c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f64884a.hashCode() + 527) * 31;
        String str = this.f65471b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f65472c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.applovin.impl.xa
    public String toString() {
        return this.f64884a + ": description=" + this.f65471b + ": value=" + this.f65472c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f64884a);
        parcel.writeString(this.f65471b);
        parcel.writeString(this.f65472c);
    }

    public zn(String str, String str2, String str3) {
        super(str);
        this.f65471b = str2;
        this.f65472c = str3;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.applovin.impl.af.b
    public void a(ud.b bVar) {
        String str = this.f64884a;
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    b3 = 0;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    b3 = 1;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    b3 = 2;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    b3 = 3;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    b3 = 4;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    b3 = 5;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    b3 = 6;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    b3 = 7;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    b3 = 8;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    b3 = 9;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    b3 = 10;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    b3 = Ascii.VT;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    b3 = Ascii.FF;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    b3 = Ascii.CR;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    b3 = Ascii.SO;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    b3 = Ascii.SI;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    b3 = Ascii.DLE;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    b3 = 17;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    b3 = Ascii.DC2;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    b3 = 19;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    b3 = Ascii.DC4;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    b3 = Ascii.NAK;
                }
                break;
        }
        try {
            switch (b3) {
                case 0:
                case 10:
                    bVar.b(this.f65472c);
                    break;
                case 1:
                case 11:
                    bVar.e(this.f65472c);
                    break;
                case 2:
                case 12:
                    bVar.d(Integer.valueOf(Integer.parseInt(this.f65472c.substring(2, 4)))).c(Integer.valueOf(Integer.parseInt(this.f65472c.substring(0, 2))));
                    break;
                case 3:
                case 17:
                    bVar.c(this.f65472c);
                    break;
                case 4:
                case 18:
                    bVar.a(this.f65472c);
                    break;
                case 5:
                case 19:
                    bVar.f(this.f65472c);
                    break;
                case 6:
                case 20:
                    String[] strArrA = xp.a(this.f65472c, "/");
                    bVar.k(Integer.valueOf(Integer.parseInt(strArrA[0]))).j(strArrA.length > 1 ? Integer.valueOf(Integer.parseInt(strArrA[1])) : null);
                    break;
                case 7:
                case 16:
                    bVar.k(this.f65472c);
                    break;
                case 8:
                case 15:
                    bVar.l(this.f65472c);
                    break;
                case 9:
                case 21:
                    bVar.e(Integer.valueOf(Integer.parseInt(this.f65472c)));
                    break;
                case 13:
                    List listA = a(this.f65472c);
                    int size = listA.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.c((Integer) listA.get(2));
                            }
                        }
                        bVar.d((Integer) listA.get(1));
                    }
                    bVar.e((Integer) listA.get(0));
                    break;
                case 14:
                    List listA2 = a(this.f65472c);
                    int size2 = listA2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.f((Integer) listA2.get(2));
                            }
                        }
                        bVar.g((Integer) listA2.get(1));
                    }
                    bVar.h((Integer) listA2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }
}
