import NativeMediaSize from './NativeMediaSize';

export async function getImageSize(uri: string) {
  return NativeMediaSize.getImageSize(uri);
}