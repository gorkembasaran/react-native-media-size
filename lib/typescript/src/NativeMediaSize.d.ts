import type { TurboModule } from 'react-native';
export interface Spec extends TurboModule {
    getImageSize(uri: string): Promise<{
        width: number;
        height: number;
    }>;
}
declare const _default: Spec;
export default _default;
//# sourceMappingURL=NativeMediaSize.d.ts.map