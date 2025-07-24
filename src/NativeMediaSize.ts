import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  getImageSize(uri: string): Promise<{ width: number; height: number }>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('MediaSize');