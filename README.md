無理矢理EUC-JP用に変換するメソッド。

public static String UnicodeToEuc(String str) {      StringBuffer result = new StringBuffer();      char c;      for (int i = 0; i < str.length(); i++) {          c = str.charAt(i);          switch (c) {          case 0x2015:              c = 0x2014;              break;          case 0x2225:              c = 0x2016;              break;          case 0xff0d:              c = 0x2212;              break;          case 0xffe0:              c = 0x00a2;              break;          case 0xffe1:              c = 0x00a3;              break;          case 0xffe2:              c = 0x00ac;              break;          case 0xffe4:              c = 0x00a6;              break;          }          result.append(c);      }      return result.toString();  }
変換後出力データを見ると、微妙に形が違うが、これしか方法がないため仕方ないね。
「Shift_JIS」に変換する時も同様に表を見ながらメソッドを完成させてほしい。
例)
byte[] eucCode; // EUC-JP
String strChar; // UNICODE
byte[] utf8Code; // UTF8
// EUC→Unicodeデータ
strChar = new String(eucCode, "EUC-JP");
// Unicode→UTF-8データ
utf8Code = strChar.getBytes("UTF-8");
