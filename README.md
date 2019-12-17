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


Copyright © 1999-2019, CSDN.NET, All Rights Reserved



搜索博文/帖子/用户
  登录
UTF-8转换成Shift_jis，识别非Shift_jis字符，如（～、①等） 原创

luyang1016

2007-11-27 阅读数：9161

关注
闭月羞花猫 2007/11/27 于南京新城

需求描述：
       在读取一本UTF-8编码的文本文档，将其中的内容转换成Shift_jis编码，如果遇到
       ～、① 之类不属于Shift_jis的字符，用特殊符号代替，无视，报错。

代码：

 public static String checkIsSjis(String inString) {
  // Create the encoder and decoder for the character encoding
  Charset charset = Charset.forName("Shift_jis");
  CharsetDecoder decoder = charset.newDecoder();
  CharsetEncoder encoder = charset.newEncoder();
  // エラー種別 説明 動作の制御方法
  // 不正入力エラー
  // 入力が正当な16ビットUnicodeシーケンスでなかった場合。 onMalformedInputメソッドを使用(3 cases)
               encoder.onMalformedInput(CodingErrorAction.REPORT);
  // ......
  // マップ不可文字エラー 入力文字シーケンスは正当であるが、指定された文字セットの文字にはマッピングされていない場合。
  // onUnmappableCharacterメソッドを使用(3 cases)
  // ① エラーが発生した入力文字を無視して処理を継続します。
  // encoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
  // ② CodingErrorAction.REPORT エラーが発生した時点で処理を中断し、戻り値または例外にてエラーを報告します。
  // encoder.onUnmappableCharacter(CodingErrorAction.REPORT);
  // ③ エラーが発生した入力文字を指定した置換文字(列)に置換して出力し、処理を継続します。置換文字は replaceWith(byte[]
  // newReplacement)
  // メソッドによって設定することができます。デフォルトは「?」(={(byte)'?'})です。設定されている置換文字列は
  // replacement メソッドにより取得できます。
   encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
   encoder.replaceWith("☆".getBytes());
  String result = inString;
  try {
   // Convert a string to bytes in a ByteBuffer
   ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(inString));
   // Convert bytes in a ByteBuffer to a character ByteBuffer and then
   // to a string.
   CharBuffer cbuf = decoder.decode(bbuf);
   result = cbuf.toString();
  } catch (CharacterCodingException cce) {
   String errorMessage = "Exception during character encoding/decoding: "
     + cce.getMessage();
   System.out.println(errorMessage);
   cce.printStackTrace();
  }
  return result;
 }
