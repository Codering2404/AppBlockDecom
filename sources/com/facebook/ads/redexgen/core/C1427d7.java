package com.facebook.ads.redexgen.core;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.d7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1427d7 extends WebChromeClient {
    public static byte[] A01;
    public static String[] A02 = {"hD342XNQVEXChvJ41FuJYkzzL30E7V8C", "VFqqxEswv4BXF4BUDT4NnG4IAUyY785", "G3ZSvK9EmqC1e5u7Ivg7hdOkIQzdfa68", "vFWJ81dDNXk", "PGv8G8TosU31EXJAVb0WhvumqcSTUHDE", "JPUBUdUfGKDjW9Qe8mrAO5frWlzvQ1oz", "qcwfoFOZSGXVTY97XWLRaEh5jd9GG5ia", "FIykCHI4yyfel4YrSgGCK0Zn6vKmeZ"};
    public final /* synthetic */ C1432dC A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{64, 69, 66, 73, 98, 89, 65, 78, 73, 94, 39, 47, 57, 57, 43, Framer.STDIN_FRAME_PREFIX, 47, 118, 106, 112, 119, 102, 96, 76, 97};
    }

    static {
        A01();
    }

    public C1427d7(C1432dC c1432dC) {
        this.A00 = c1432dC;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A00(10, 7, 124), consoleMessage.message());
                jSONObject.put(A00(0, 10, 26), consoleMessage.lineNumber());
                jSONObject.put(A00(17, 8, 51), consoleMessage.sourceId());
            } catch (JSONException unused) {
            }
            String string = jSONObject.toString();
            this.A00.A0D.A04(VH.A0N, null);
            this.A00.A0E.A04(AbstractC1060Td.A14, string);
            this.A00.A0B.A0F().A69(string);
        }
        boolean zOnConsoleMessage = super.onConsoleMessage(consoleMessage);
        if (A02[5].charAt(17) == '8') {
            throw new RuntimeException();
        }
        A02[3] = "bhT1kVUsfNz";
        return zOnConsoleMessage;
    }
}
