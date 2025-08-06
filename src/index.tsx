import NativeMediaSize from './NativeMediaSize';

export async function getImageSize(uri: string) {
  return NativeMediaSize.getImageSize(uri);
}

export async function isImageMirrored(uri: string) {
  return NativeMediaSize.isImageMirrored(uri);
}