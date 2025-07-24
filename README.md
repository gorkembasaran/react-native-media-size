# 📸 react-native-media-size

A simple React Native native module for retrieving **accurate image dimensions** (width & height) from `content://` URIs on **Android** devices using the `MediaSize` API.

> ✅ Android only  
> ❌ Not compatible with iOS

---

## 🚀 Features

- 🔍 Retrieve image size from Android `MediaSize`
- ⚡ Works with `content://` URIs (e.g. selected images from gallery)
- 📦 Lightweight and easy to use
- 🔧 Written in Kotlin + TypeScript
- 💬 Fully typed API

---

## 📦 Installation

Using npm:

```sh
npm install react-native-media-size
```
```sh
yarn add react-native-media-size
```
## Usage


```js
import { getImageSize } from 'react-native-media-size';

type ImageSize = {
  width: number;
  height: number;
};

const uri = 'content://media/external/images/media/123';

try {
  const size = await getImageSize(uri);
  console.log('Image size:', size.width, size.height);
} catch (error) {
  console.error('Failed to get image size:', error);
}
```
## Example Utility Wrapper


```js
utils/getImageRealSize
import { getImageSize } from 'react-native-media-size';

export const fetchImageSize = async (imageUri: string) => {
  try {
    const size = await getImageSize(imageUri);
    return size;
  } 
  catch (err) {
    console.error('❌ Resim boyutu alınamadı:', err);
  }
};
```
## Platform Check Usage

```js
const [selectedPhoto, setSelectedPhoto] = useState<string | undefined>(undefined);

import { fetchImageSize } from '../../utils/getRealImageSize';

if (Platform.OS === 'android' && selectedPhoto.startsWith('content://')) {
    const realSize = await fetchImageSize(selectedPhoto);
    if (realSize) {
      originalWidth = realSize.width;
      originalHeight = realSize.height;
    } 
    else {
      console.warn('cannot get');
    }
  }
```


## License

MIT © Görkem Başaran

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
