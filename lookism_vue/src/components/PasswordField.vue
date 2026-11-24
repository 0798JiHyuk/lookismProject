<script setup>
import { ref } from 'vue'

const password = defineModel({ type: String, required: true })
defineProps({
  id: { type: String, required: true },
  label: { type: String, required: true },
  autocomplete: { type: String, required: true },
  minLength: { type: Number, default: 1 },
  description: { type: String, default: undefined },
  disabled: Boolean,
})
const visible = ref(false)
</script>

<template>
  <div class="field">
    <label :for="id">{{ label }}</label>
    <div class="inline-control">
      <input :id="id" v-model="password" :type="visible ? 'text' : 'password'"
        :autocomplete="autocomplete" :minlength="minLength" maxlength="72"
        :aria-describedby="description" :disabled="disabled" required />
      <button class="secondary" type="button" :aria-label="label + (visible ? ' 숨기기' : ' 보기')"
        :aria-controls="id" :disabled="disabled" @click="visible = !visible">
        {{ visible ? '숨기기' : '보기' }}
      </button>
    </div>
  </div>
</template>
